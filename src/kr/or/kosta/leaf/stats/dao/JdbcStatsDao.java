package kr.or.kosta.leaf.stats.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import kr.or.kosta.leaf.stats.domain.Stats;

public class JdbcStatsDao implements StatsDao {

	private DataSource dataSource;
	
	public JdbcStatsDao() {}
	
	public JdbcStatsDao(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	
	@Override
	public List<Stats> getStatses(String startDate, String endDate) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<Stats> statses = new ArrayList<Stats>();
		
		String sql = " SELECT\r\n" + 
							"    total.order_date,\r\n" + 
							"    (SELECT product_name FROM product WHERE product_code = item.product_code) product_name,\r\n" + 
							"    SUM(item.order_count) order_count\r\n" + 
							" FROM\r\n" + 
							"    total_order total,\r\n" + 
							"    order_item item\r\n" + 
							" WHERE\r\n" + 
							"    total.order_no = item.order_no\r\n" + 
							"    AND   TO_CHAR(total.order_date,'YYYY/MM/DD') BETWEEN ? AND ? \r\n" + 
							" GROUP BY\r\n" + 
							"    total.order_date,\r\n" + 
							"    item.product_code\r\n" + 
							" ORDER BY\r\n" + 
							"    total.order_date,\r\n" + 
							"    item.product_code\r\n";
		
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, startDate.trim());
 			pstmt.setString(2, endDate.trim());
			
			rs = pstmt.executeQuery();
			System.out.println(sql);
			while (rs.next()) {
				Stats stats = new Stats();
				
				stats.setOrderDate(rs.getString("order_date").split(" ")[0]);
				stats.setProductName(rs.getString("product_name"));
				stats.setOrderCount(rs.getInt("order_count"));
				
				statses.add(stats);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("JdbcStatsDao.getStatses(String startDate, String endDate) 실행 중 예외발생", e);
		} finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return statses;
	}

}
