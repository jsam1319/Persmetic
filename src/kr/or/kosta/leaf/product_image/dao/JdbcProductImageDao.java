package kr.or.kosta.leaf.product_image.dao;

/**
 * 이미지 제공하기 위한 
 * product_image 테이블 매칭 JdbcDao
 * 
 * ------ 2017-09-27------
 * CRUD 구현
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
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;
		
		String sql = " INSERT INTO product_image(product_code, image_number, image_name, image_front) " +
		             	   " VALUES   (?, ?, ?, ?)";
		
		try {
			con = dataSource.getConnection();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, image.getProductCode());
			pstmt.setInt(2, image.getImageNumber());
			pstmt.setString(3, image.getImageName());
			pstmt.setString(4, image.getImageFront());
			
			pstmt.executeUpdate();
			
			con.commit();
		} catch (Exception e) {
			e.printStackTrace();
			
			try {
				con.rollback();
			} catch (SQLException e1) {}
			throw new RuntimeException("JdbcProductImageDao.create(Product) 실행 중 예외발생", e);
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null)   con.close(); // 커넥션풀에 반납
			} catch (Exception e) {}
		}
	}

	@Override
	public ProductImage read(int productCode, int imageNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(int productCode, int imageNumber, ProductImage image) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int productCode, int imageNumber) {
		// TODO Auto-generated method stub
		
	}

	
}












