package kr.or.kosta.leaf.cart.dao;

import java.util.List;

import kr.or.kosta.leaf.cart.domain.Cart;

/**
 * Cart 테이블 매칭 Dao Interface
 * 
 * ------ 2017-09-28------
 * 
 * -----------------------
 * 
 * @author 손정화
 */

public interface CartDao {
	/* DB CRUD*/
	/** 장바구니 상품 등록 */
	public void create(Cart cart);
	
	/** 장바구니 상품 조회 */
	public Cart read(int productCode, int ctmNo);
	
	/** 회원별 장바구니 리스트 */
	public List<Cart> listAll(int ctm_no);
	
	/** 장바구니 상품 삭제 */
	public void delete(int productCode, int ctmNo);
	
}







