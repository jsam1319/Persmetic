package kr.or.kosta.leaf.product_inquiry.dao;

import kr.or.kosta.leaf.product_inquiry.domain.ProductInquiry;

/**
 * 상품 문의를 위한 Dao Interface
 *
 * @author 박연주
 *
 */

public interface ProductInquiryDao {
	
	/** 상품문의등록 */
	public void create(ProductInquiry inquiry);
	
	/** 상품정보 삭제 */
	public void delete(int inquiryno);
}
