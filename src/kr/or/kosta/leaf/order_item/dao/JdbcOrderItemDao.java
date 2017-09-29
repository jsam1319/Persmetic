package kr.or.kosta.leaf.order_item.dao;

/**
 * JDBC API를 이용한 주문(total_order) 테이블 관련 영속성 처리 DAO 클래스
 * order_item 테이블 매칭 JdbcDao
 * 
 * ------ 2017-09-28------
 * CRUD 구현(Update 불필요 -> 구현 X)
 * -----------------------
 * 
 * @author 손정화
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import kr.or.kosta.leaf.order_item.domain.OrderItem;

public class JdbcOrderItemDao implements OrderItemDao{
	
private DataSource dataSource;
	
	public JdbcOrderItemDao() {}
	
	public JdbcOrderItemDao(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	
	/** 주문항목 추가 */
	@Override
	public void create(OrderItem orderItem) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		String sql = " INSERT INTO total_order(order_no, product_code, order_price, order_count)" + 
		             " VALUES   (?, ?, ?, ?)";
		
		try {
			con = dataSource.getConnection();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, orderItem.getOrderNo());
			pstmt.setInt(2, orderItem.getProductCode());
			pstmt.setInt(3, orderItem.getOrderPrice());
			pstmt.setInt(4, orderItem.getOrderCount());
			
			pstmt.executeUpdate();
			
			con.commit();
		} catch (Exception e) {
			e.printStackTrace();
			
			try {
				con.rollback();
			} catch (SQLException e1) {}
			throw new RuntimeException("JdbcOrderItemDao.create(orderItem) 실행 중 예외발생", e);
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null)   con.close(); // 커넥션풀에 반납
			} catch (Exception e) {}
		}
	}
	

	/** 통계를 위한 주문항목 상품보기 */
	public List<OrderItem> read(int productCode) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<OrderItem> items = new ArrayList<OrderItem>();

		String sql = " SELECT order_no, product_code, order_price, order_count " +
					 " FROM order_item " +
					 " WHERE product_code = ? ";

		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, productCode);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				OrderItem orderItem = new OrderItem();
				orderItem.setOrderNo(rs.getInt("order_no"));
				orderItem.setProductCode(rs.getInt("product_code"));
				orderItem.setOrderPrice(rs.getInt("order_price"));
				orderItem.setOrderCount(rs.getInt("order_count"));
				
				items.add(orderItem);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("JdbcOrderItemDao.read(int orderNo, int productCode) 실행 중 예외발생", e);
		} finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return items;
	}	
	
	/** 주문항목 상품보기 */
	public OrderItem read(int orderNo, int productCode) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = " SELECT order_no, product_code, order_price, order_count " +
					 " FROM order_item " +
					 " WHERE order_no = ? " +
					 " AND product_code = ? ";

		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, orderNo);
			pstmt.setInt(2, productCode);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				OrderItem orderItem = new OrderItem();
				orderItem.setOrderNo(rs.getInt("order_no"));
				orderItem.setProductCode(rs.getInt("product_code"));
				orderItem.setOrderPrice(rs.getInt("order_price"));
				orderItem.setOrderCount(rs.getInt("order_count"));
				return orderItem;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("JdbcOrderItemDao.read(int orderNo, int productCode) 실행 중 예외발생", e);
		} finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}	
	
	/** 주문항목 리스트 */
	public List<OrderItem> listAll() {
		List<OrderItem> list = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = " SELECT order_no, product_code, order_price, order_count " +
					 " FROM order_item ";
		
		try {
			list = new ArrayList<OrderItem>();
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				OrderItem orderItem = new OrderItem();
				orderItem.setOrderNo(rs.getInt("order_no"));
				orderItem.setProductCode(rs.getInt("product_code"));
				orderItem.setOrderPrice(rs.getInt("order_price"));
				orderItem.setOrderCount(rs.getInt("order_count"));
				list.add(orderItem);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	

	/** 주문항목 삭제 */
	@Override
	public void delete(int orderNo, int productCode) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		String sql = " DELETE FROM order_item " +
		             " WHERE order_no = ? " +
		             " AND product_code = ? ";
		
		try {
			con = dataSource.getConnection();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, orderNo);
			pstmt.setInt(2, productCode);
			
			pstmt.executeUpdate();
			
			con.commit();
		} catch (Exception e) {
			e.printStackTrace();
			
			try {
				con.rollback();
			} catch (SQLException e1) {}
			throw new RuntimeException("JdbcOrderItemDao.delete(int orderNo, int productCode) 실행 중 예외발생", e);
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null)   con.close(); // 커넥션풀에 반납
			} catch (Exception e) {}
		}
	}

}












