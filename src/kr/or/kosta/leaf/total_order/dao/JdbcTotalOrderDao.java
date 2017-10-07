package kr.or.kosta.leaf.total_order.dao;

/**
 * JDBC API를 이용한 주문(total_order) 테이블 관련 영속성 처리 DAO 클래스
 * total_order 테이블 매칭 JdbcDao
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

import kr.or.kosta.leaf.total_order.domain.TotalOrder;

public class JdbcTotalOrderDao implements TotalOrderDao{
	
private DataSource dataSource;
	
	public JdbcTotalOrderDao() {}
	
	public JdbcTotalOrderDao(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	
	/** 주문 추가 */
	@Override
	public void create(TotalOrder totalOrder) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		String sql = " INSERT INTO total_order(order_no, order_totalprice, order_address, order_recipient," + 
					 " order_date, order_payoption, order_yn, ctm_no) " +
		             " VALUES   (?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			con = dataSource.getConnection();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, totalOrder.getOrderNo());
			pstmt.setInt(2, totalOrder.getOrderTotalprice());
			pstmt.setString(3, totalOrder.getOrderAddress());
			pstmt.setString(4, totalOrder.getOrderRecipient());
			pstmt.setString(5, totalOrder.getOrderDate());
			pstmt.setString(6, totalOrder.getOrderPayoption());
			pstmt.setString(7, totalOrder.getOrderYn());
			pstmt.setInt(8, totalOrder.getCtmNo());
			
			pstmt.executeUpdate();
			
			con.commit();
		} catch (Exception e) {
			e.printStackTrace();
			
			try {
				con.rollback();
			} catch (SQLException e1) {}
			throw new RuntimeException("JdbcTotalOrderDao.create(TotalOrder) 실행 중 예외발생", e);
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null)   con.close(); // 커넥션풀에 반납
			} catch (Exception e) {}
		}
	}
	

	/** 주문 상품보기 */
	public TotalOrder read(int orderNo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = " SELECT order_no, order_totalprice, order_address, order_recipient " +
					 " order_date, order_payoption, order_yn, ctm_no" +
					 " FROM total_order " +
					 " WHERE order_no = ? ";

		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, orderNo);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				TotalOrder totalOrder = new TotalOrder();
				totalOrder.setOrderNo(rs.getInt("order_no"));
				totalOrder.setOrderTotalprice(rs.getInt("order_totalprice"));
				totalOrder.setOrderAddress(rs.getString("order_address"));
				totalOrder.setOrderRecipient(rs.getString("order_recipient"));
				totalOrder.setOrderDate(rs.getString("order_date"));
				totalOrder.setOrderPayoption(rs.getString("order_payoption"));
				totalOrder.setOrderYn(rs.getString(rs.getString("order_yn")));
				totalOrder.setCtmNo(rs.getInt("ctm_no"));
				return totalOrder;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("JdbcTotalOrderDao.read(int orderNo) 실행 중 예외발생", e);
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
	
	
	/** 주문 상품보기 */
	public List<TotalOrder> read(String startDate, String endDate) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<TotalOrder> orders = new ArrayList<TotalOrder>();
		
		String sql = " SELECT order_no, order_totalprice, order_address, order_recipient " +
					 " order_date, order_payoption, order_yn, ctm_no" +
					 " FROM total_order " +
					 " WHERE order_date between ? and ?";

		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, startDate);
			pstmt.setString(2, endDate);
			
			rs = pstmt.executeQuery();

			while (rs.next()) {
				TotalOrder totalOrder = new TotalOrder();
				
				totalOrder.setOrderNo(rs.getInt("order_no"));
				totalOrder.setOrderTotalprice(rs.getInt("order_totalprice"));
				totalOrder.setOrderAddress(rs.getString("order_address"));
				totalOrder.setOrderRecipient(rs.getString("order_recipient"));
				totalOrder.setOrderDate(rs.getString("order_date"));
				totalOrder.setOrderPayoption(rs.getString("order_payoption"));
				totalOrder.setOrderYn(rs.getString(rs.getString("order_yn")));
				totalOrder.setCtmNo(rs.getInt("ctm_no"));
				
				orders.add(totalOrder);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("JdbcTotalOrderDao.read(String startDate, String endDate) 실행 중 예외발생", e);
		} finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return orders;
	}	
	
	
	
	
	/** 주문 리스트 */
	public List<TotalOrder> listAll() {
		List<TotalOrder> list = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = " SELECT order_no, order_totalprice, order_address, order_recipient " +
					 " order_date, order_payoption, order_yn, ctm_no" +
					 " FROM total_order ";
		
		try {
			list = new ArrayList<TotalOrder>();
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				TotalOrder totalOrder = new TotalOrder();
				totalOrder.setOrderNo(rs.getInt("order_no"));
				totalOrder.setOrderTotalprice(rs.getInt("order_totalprice"));
				totalOrder.setOrderAddress(rs.getString("order_address"));
				totalOrder.setOrderRecipient(rs.getString("order_recipient"));
				totalOrder.setOrderDate(rs.getString("order_date"));
				totalOrder.setOrderPayoption(rs.getString("order_payoption"));
				totalOrder.setOrderYn(rs.getString(rs.getString("order_yn")));
				totalOrder.setCtmNo(rs.getInt("ctm_no"));
				list.add(totalOrder);
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
	

	/** 주문 삭제 */
	@Override
	public void delete(int orderNo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		String sql = " DELETE FROM total_order " +
		             " WHERE order_no = ? ";
		
		try {
			con = dataSource.getConnection();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, orderNo);
			
			pstmt.executeUpdate();
			
			con.commit();
		} catch (Exception e) {
			e.printStackTrace();
			
			try {
				con.rollback();
			} catch (SQLException e1) {}
			throw new RuntimeException("JdbcTotalOrderDao.delete(int orderNo) 실행 중 예외발생", e);
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null)   con.close(); // 커넥션풀에 반납
			} catch (Exception e) {}
		}
	}

}












