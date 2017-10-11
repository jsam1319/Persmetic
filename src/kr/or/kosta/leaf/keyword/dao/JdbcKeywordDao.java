package kr.or.kosta.leaf.keyword.dao;

/**
 * 검색, 추천 시 더욱 정확하고 빠른 정보를 제공하기 위한 
 * Keyword 테이블 매칭 JdbcDao
 * 
 * ------ 2017-09-27------
 * CRUD 구현(Update 불필요 -> 구현 X)
 * 
 * 
 * -----------------------
 * 
 * @author 이재현
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import kr.or.kosta.leaf.keyword.domain.Keyword;


public class JdbcKeywordDao implements KeywordDao{
	
private DataSource dataSource;
	
	public JdbcKeywordDao() {}
	
	public JdbcKeywordDao(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void create(Keyword keyword) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;
		
		String sql = " INSERT INTO keyword(keyword_name, product_code) " +
		             	   " VALUES   (?, ?)";
		
		try {
			con = dataSource.getConnection();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, keyword.getKeywordName());
			pstmt.setInt(2, keyword.getProductCode());
			
			pstmt.executeUpdate();
			
			con.commit();
		} catch (Exception e) {
			e.printStackTrace();
			
			try {
				con.rollback();
			} catch (SQLException e1) {}
			throw new RuntimeException("JdbcKeywordDao.create(Keyword) 실행 중 예외발생", e);
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null)   con.close(); // 커넥션풀에 반납
			} catch (Exception e) {}
		}
	}

	@Override
	public Keyword read(String keywordName, int productCode) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
			
		Keyword keyword = null;
				
		String sql = " SELECT keyword_name, product_code"
						+ " FROM keyword " 
				       	+ " WHERE keyword_name = ?" 
				       	+ " AND product_code = ?";
				             			  
		try {
			con = dataSource.getConnection();
			con.setAutoCommit(false);
				
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, keywordName);
			pstmt.setInt(2, productCode);
					
			rs = pstmt.executeQuery();
					
			if(rs.next()) keyword = new Keyword(rs.getString("keyword_name"), rs.getInt("product_code"));
					
			con.commit();
		} catch (Exception e) {
			e.printStackTrace();
			
			try {
				con.rollback();
			} catch (SQLException e1) {}
				throw new RuntimeException("JdbcKeywordDao.read(String keywordName, int productCode) 실행 중 예외발생", e);
			} finally {
				try {
					if(pstmt != null) pstmt.close();
					if(con != null)   con.close(); // 커넥션풀에 반납
				} catch (Exception e) {}
			}
				
			return keyword;
	}
	
	@Override
	public List<Keyword> getKeywords(int productCode) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<Keyword> keywords = new ArrayList<Keyword>();
			
		String sql = " SELECT keyword_name, product_code "
						+ " FROM keyword " 
				       	+ " WHERE product_code = ?";
				             			  
		try {
			con = dataSource.getConnection();
			con.setAutoCommit(false);
				
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, productCode);
					
			rs = pstmt.executeQuery();
					
			while(rs.next()) keywords.add(new Keyword(rs.getString("keyword_name"), rs.getInt("product_code")));
					
			con.commit();
		} catch (Exception e) {
			e.printStackTrace();
			
			try {
				con.rollback();
			} catch (SQLException e1) {}
				throw new RuntimeException("JdbcKeywordDao.read(String keywordName, int productCode) 실행 중 예외발생", e);
			} finally {
				try {
					if(pstmt != null) pstmt.close();
					if(con != null)   con.close(); // 커넥션풀에 반납
				} catch (Exception e) {}
			}
				
			return keywords;
	}

	@Override
	public List<String> getKeywordNames(String keywordName) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<String> keywordNames = new ArrayList<String>();
			
		Keyword keyword = null;
				
		String sql = " SELECT DISTINCT keyword_name, hit_count"
						+ " FROM keyword " 
				       	+ " WHERE keyword_name like ?"
				       	+ " ORDER BY hit_count DESC";
				             			  
		try {
			con = dataSource.getConnection();
			con.setAutoCommit(false);
				
			pstmt = con.prepareStatement(sql);
			
			String keywordString = "%" + keywordName + "%";
			
			pstmt.setString(1, keywordString);
					
			rs = pstmt.executeQuery();
					
			while(rs.next()) {
				keywordNames.add(rs.getString("keyword_name"));
			}
					
			con.commit();
		} catch (Exception e) {
			e.printStackTrace();
			
			try {
				con.rollback();
			} catch (SQLException e1) {}
				throw new RuntimeException("JdbcKeywordDao.read(String keywordName, int productCode) 실행 중 예외발생", e);
			} finally {
				try {
					if(pstmt != null) pstmt.close();
					if(con != null)   con.close(); // 커넥션풀에 반납
				} catch (Exception e) {}
			}
				
			return keywordNames;
	}
	
	
	
	@Override
	public void delete(String keywordName, int productCode) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;
		
		String sql = " DELETE FROM keyword " +
		             	   " WHERE keyword_name = ?"
		             	+ " AND product_code = ?";
		
		try {
			con = dataSource.getConnection();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, keywordName);
			pstmt.setInt(2, productCode);
			
			pstmt.executeUpdate();
			
			con.commit();
		} catch (Exception e) {
			e.printStackTrace();
			
			try {
				con.rollback();
			} catch (SQLException e1) {}
			throw new RuntimeException("JdbcKeywordDao.delete(String keywordName, int productCode) 실행 중 예외발생", e);
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null)   con.close(); // 커넥션풀에 반납
			} catch (Exception e) {}
		}
	}
	
	@Override
	public void plusHitCount(String keywordName) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		String sql = " UPDATE keyword " +
		             	   " SET hit_count = hit_count + 1"
		             	+ " WHERE keyword_name = ? ";

		
		try {
			con = dataSource.getConnection();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, keywordName);

			
			pstmt.executeUpdate();
			
			con.commit();
		} catch (Exception e) {
			e.printStackTrace();
			
			try {
				con.rollback();
			} catch (SQLException e1) {}
			throw new RuntimeException(" plusHitCount(Keyword keyword) 실행 중 예외발생", e);
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null)   con.close(); // 커넥션풀에 반납
			} catch (Exception e) {}
		}
	}
}












