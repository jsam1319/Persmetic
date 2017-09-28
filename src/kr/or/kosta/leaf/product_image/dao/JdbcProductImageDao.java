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











