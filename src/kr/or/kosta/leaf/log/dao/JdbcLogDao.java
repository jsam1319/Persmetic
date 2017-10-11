package kr.or.kosta.leaf.log.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import kr.or.kosta.leaf.log.domain.Log;
import kr.or.kosta.leaf.log.domain.LogType;

public class JdbcLogDao implements LogDao {

	DataSource dataSource;
	
	public JdbcLogDao() {
		super();
		// TODO Auto-generated constructor stub
	}

	public JdbcLogDao(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	
	@Override
	public List<Log> listLog(int ctmNo) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<Log> logs = new ArrayList<Log>();
		
		String sql = " SELECT log_no, ctm_no, log_type, log_content, log_date "
						+ " FROM log "
						+ " WHERE ctm_no = ?";
		
		try {
			con = dataSource.getConnection();

			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, ctmNo);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Log log = new Log();
				
				log.setCtmNo(rs.getInt("ctm_no"));
				log.setlogNo(rs.getInt("log_no"));
				log.setLogType(LogType.valueOf(rs.getString("log_type")));
				log.setLogContent(rs.getString("log_content"));
				log.setLogDate(rs.getString("log_date"));
				
				logs.add(log);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
			try {
				con.rollback();
			} catch (SQLException e1) {}
			throw new RuntimeException("insertLog(Log log) 실행 중 예외발생", e);
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null)   con.close(); // 커넥션풀에 반납
			} catch (Exception e) {}
		}
		
		return logs;
	}

	@Override
	public void insertLog(Log log) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;
		
		String sql = " INSERT INTO log(log_no, ctm_no, log_type, log_content)" + 
		             		" VALUES  ((SELECT MAX(log_no)+1 FROM log), ?, ?, ?)";
		
		try {
			con = dataSource.getConnection();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, log.getCtmNo());
			pstmt.setString(2, log.getLogType().toString());
			pstmt.setString(3, log.getLogContent());
			
			pstmt.executeUpdate();
			
			con.commit();
		} catch (Exception e) {
			e.printStackTrace();
			
			try {
				con.rollback();
			} catch (SQLException e1) {}
			throw new RuntimeException("insertLog(Log log) 실행 중 예외발생", e);
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null)   con.close(); // 커넥션풀에 반납
			} catch (Exception e) {}
		}
	}

}
