package kr.or.kosta.leaf.product_answer.dao;

import kr.or.kosta.leaf.product_answer.domain.ProductAnswer;

/**
 * 상품문의답변 관리를 위한 Dao Interface
 *
 * @author 박연주
 *
 */

public interface ProductAnswerDao {

	/** 상품문의답변등록 */
	public void create(ProductAnswer answer);
	
	/** 상품문의답변 삭제 */
	public void delete(int answerno);
}
