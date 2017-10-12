package kr.or.kosta.leaf.order_log.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import kr.or.kosta.leaf.keyword.domain.Keyword;
import kr.or.kosta.leaf.order_log.domain.OrderLog;

public class JdbcOrderLogDao implements OrderLogDao {

	private DataSource dataSource;

	public JdbcOrderLogDao() {
		super();
		// TODO Auto-generated constructor stub
	}

	public JdbcOrderLogDao(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	
	/* (non-Javadoc)
	 * @see kr.or.kosta.leaf.order_log.dao.OrderLogDao#listByDate(java.lang.String, java.lang.String)
	 */
	@Override
	public List<OrderLog> listByDate(String startDate, String endDate) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<OrderLog> orderLogs = new ArrayList<OrderLog>();
			
		Keyword keyword = null;
				
		String sql = "SELECT product_code,\r\n" + 
							"  (SELECT product_name FROM product WHERE product_code = item.product_code\r\n" + 
							"  ) product_name,\r\n" + 
							"  order_price,\r\n" + 
							"  order_count,\r\n" + 
							"  order_date,\r\n" + 
							"  (SELECT ctm_name FROM customer WHERE ctm_no = total.ctm_no\r\n" + 
							"  ) ctm_name,\r\n" + 
							"  order_yn\r\n" + 
							"FROM order_item item,\r\n" + 
							"  total_order total\r\n" + 
							"WHERE item.order_no = total.order_no\r\n" + 
							"AND total.order_date between ? AND ?  \r\n" + 
							"ORDER BY total.order_date DESC";
				             			  
		try {
			con = dataSource.getConnection();
			con.setAutoCommit(false);
				
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, startDate);
			pstmt.setString(2, endDate);
			
			rs = pstmt.executeQuery();
					
			while(rs.next()) {
				OrderLog orderLog = new OrderLog();
				
				orderLog.setProductCode(rs.getInt("product_code"));
				orderLog.setProductName(rs.getString("product_name"));
				orderLog.setOrderPrice(rs.getInt("order_price"));
				orderLog.setOrderCount(rs.getInt("order_count"));
				orderLog.setOrderDate(rs.getString("order_date"));
				orderLog.setOrderYN(rs.getString("order_yn"));
				orderLog.setCtmName(rs.getString("ctm_name"));
				
				orderLogs.add(orderLog);
			}
					
			con.commit();
		} catch (Exception e) {
			e.printStackTrace();
			
			try {
				con.rollback();
			} catch (SQLException e1) {}
				throw new RuntimeException("JdbcOrderLogDao.listByDate(String startDate, int endDate) 실행 중 예외발생", e);
			} finally {
				try {
					if(pstmt != null) pstmt.close();
					if(con != null)   con.close(); // 커넥션풀에 반납
				} catch (Exception e) {}
			}
				
			return orderLogs;
	}

	
}
