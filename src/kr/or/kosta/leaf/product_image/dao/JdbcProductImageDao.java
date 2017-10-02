package kr.or.kosta.leaf.product_image.dao;

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
import kr.or.kosta.leaf.product_image.domain.ProductImage;


/**
 * JDBC API를 이용한 사용자(users) 테이블 관련 영속성 처리 DAO 클래스
 * DAO 패턴 적용
 * @author 김기정
 */
public class JdbcProductImageDao implements ProductImageDao{
	
private DataSource dataSource;
	
	public JdbcProductImageDao() {}
	
	public JdbcProductImageDao(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void create(ProductImage image) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		String sql = " INSERT INTO product_image(image_no, image_name) " +
		             	   " VALUES   ((SELECT max(image_no) + 1 FROM product_image) , ?)";
		
		try {
			con = dataSource.getConnection();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1,  image.getImageName());
			
			pstmt.executeUpdate();
			
			con.commit();
		} catch (Exception e) {
			e.printStackTrace();
			
			try {
				con.rollback();
			} catch (SQLException e1) {}
			throw new RuntimeException("JdbcProductImageDao.create(ProductImage) 실행 중 예외발생", e);
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null)   con.close(); // 커넥션풀에 반납
			} catch (Exception e) {}
		}
	}

	@Override
	public ProductImage read(int imageNo) {
		// TODO Auto-generated method stub
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = " SELECT product_code, image_no, image_name, image_front "
		             	 +" FROM product_image "
		             	 +" WHERE image_no = ?";
		
		try {
			con = dataSource.getConnection();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, imageNo);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) 
				return new ProductImage(rs.getInt("image_no"), rs.getString("image_name"));
			
			con.commit();
		} catch (Exception e) {
			e.printStackTrace();
			
			try {
				con.rollback();
			} catch (SQLException e1) {}
			throw new RuntimeException("JdbcProductImageDao.read(ProductImage) 실행 중 예외발생", e);
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null)   con.close(); // 커넥션풀에 반납
			} catch (Exception e) {}
		}
		return null;
	}

	@Override
	public void update(int imageNo, ProductImage image) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "UPDATE product_image " + 
						   " SET image_name = ? " + 
						  " WHERE image_no = ? ";
						  
		
		try {
			con = dataSource.getConnection();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, image.getImageName());
			pstmt.setInt(2, imageNo);
			
	
			
			pstmt.executeUpdate();
			
			con.commit();
		} catch (Exception e) {
			e.printStackTrace();
			
			try {
				con.rollback();
			} catch (SQLException e1) {}
			throw new RuntimeException("JdbcProductImageDao.update(ProductImage) 실행 중 예외발생", e);
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null)   con.close(); // 커넥션풀에 반납
			} catch (Exception e) {}
		}
	}

	@Override
	public void delete(int imageNo) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;
		
		String sql = " DELETE FROM product_image " +
						  " WHERE image_no = ?";
		
		try {
			con = dataSource.getConnection();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, imageNo);
			
			pstmt.executeUpdate();
			
			con.commit();
		} catch (Exception e) {
			e.printStackTrace();
			
			try {
				con.rollback();
			} catch (SQLException e1) {}
			throw new RuntimeException("JdbcProductImageDao.delete(ProductImage) 실행 중 예외발생", e);
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null)   con.close(); // 커넥션풀에 반납
			} catch (Exception e) {}
		}
	}

	
	
	
	
}












