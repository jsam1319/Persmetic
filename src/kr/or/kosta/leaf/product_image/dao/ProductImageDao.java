package kr.or.kosta.leaf.product_image.dao;

import kr.or.kosta.leaf.product_image.domain.ProductImage;


/**
 * 검색, 추천 시 더욱 정확하고 빠른 정보를 제공하기 위한 
 * Keyword 테이블 매칭 Dao Interface
 * 
 * ------ 2017-09-27------
 * 
 * 
 * -----------------------
 * 
 * @author 이재현
 */
public interface ProductImageDao {
	
	/* DB CRUD*/
	public void create(ProductImage image);
	
	public ProductImage read(int imageNo);
	
	public void update(int imageNo, ProductImage image);
	
	public void delete(int imageNo);
	

}







