package kr.or.kosta.leaf.cart.dao;

/**
 * JDBC API를 이용한 카트(cart) 테이블 관련 영속성 처리 DAO 클래스
 * Cart 테이블 매칭 JdbcDao
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

import kr.or.kosta.leaf.cart.domain.Cart;


public class JdbcCartDao implements CartDao{
	
private DataSource dataSource;
	
	public JdbcCartDao() {}
	
	public JdbcCartDao(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	
	/** 장바구니 추가 */
	@Override
	public void create(Cart cart) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		String sql = " INSERT INTO cart(product_code, ctm_no, cart_quantity, cart_price, cart_no) " +
		             	   " VALUES (?, ?, ?, ?, (SELECT MAX(cart_no)+1 FROM cart) )";
		
		try {
			con = dataSource.getConnection();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, cart.getProductCode());
			pstmt.setInt(2, cart.getCtmNo());
			pstmt.setInt(3, cart.getCartQuantity());
			pstmt.setInt(4, cart.getCartPrice());
			
			pstmt.executeUpdate();
			
			con.commit();
		} catch (Exception e) {
			e.printStackTrace();
			
			try {
				con.rollback();
			} catch (SQLException e1) {}
			throw new RuntimeException("JdbcCartDao.create(Cart) 실행 중 예외발생", e);
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null)   con.close(); // 커넥션풀에 반납
			} catch (Exception e) {}
		}
	}
	

	/** 장바구니 상품보기 */
	public Cart read(int productCode, int ctmNo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = " SELECT product_code, ctm_no, cart_quantity, cart_price, cart_no " +
					 " FROM cart " +
					 " WHERE product_code = ? " +
					 " AND ctm_no = ?";

		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, productCode);
			pstmt.setInt(2, ctmNo);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				Cart cart = new Cart();
				cart.setProductCode(rs.getInt("product_code"));
				cart.setCtmNo(rs.getInt("ctm_no"));
				cart.setCartQuantity(rs.getInt("cart_quanity"));
				cart.setCartPrice(rs.getInt("cart_price"));
				cart.setCartNo(rs.getInt("cart_no"));
				return cart;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("JdbcCartDao.read(int productCode) 실행 중 예외발생", e);
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
	
	
	/** 회원별 장바구니 리스트 */
	public List<Cart> listAll(int ctmNo) {
		List<Cart> list = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = " SELECT product_code, ctm_no, cart_quantity, cart_price, cart_no " + 
					 " FROM cart " +
					 " WHERE ctm_no = ? ";
		
		try {
			list = new ArrayList<Cart>();
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			System.out.println(sql);
			pstmt.setInt(1, ctmNo);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Cart cart = new Cart();
				cart.setProductCode(rs.getInt("product_code"));
				cart.setCtmNo(rs.getInt("ctm_no"));
				cart.setCartQuantity(rs.getInt("cart_quantity"));
				cart.setCartPrice(rs.getInt("cart_price"));
				cart.setCartNo(rs.getInt("cart_no"));
				list.add(cart);
				
				System.out.println(cart);
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
	

	/** 장바구니 삭제 */
	@Override
	public void delete(int productCode, int ctmNo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		String sql = " DELETE FROM cart " +
		             " WHERE product_code = ? " +
		             " AND ctm_no = ? ";
		
		try {
			con = dataSource.getConnection();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, productCode);
			pstmt.setInt(2, ctmNo);
			
			pstmt.executeUpdate();
			
			con.commit();
		} catch (Exception e) {
			e.printStackTrace();
			
			try {
				con.rollback();
			} catch (SQLException e1) {}
			throw new RuntimeException("JdbcCartDao.delete(int productCode, int ctmNo) 실행 중 예외발생", e);
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null)   con.close(); // 커넥션풀에 반납
			} catch (Exception e) {}
		}
	}

}












