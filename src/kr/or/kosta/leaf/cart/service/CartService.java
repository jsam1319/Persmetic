package kr.or.kosta.leaf.cart.service;

import java.util.List;

import kr.or.kosta.leaf.cart.domain.Cart;
import kr.or.kosta.leaf.product.domain.Product;

/**
 * Domain(업무영역)별 고객의 요구사항을 반영하는 비즈니스 메소드 선언
 * 
 * *************************
 * 2017-09-30 - 이재현
 * 상품 번호에 따른 상품 명을 검색하기 위한 
 * 메소드 추가 
 * *************************
 * 
 * 
 * @author 손정화
 *
 */
public interface CartService {
	
	/** 회원별 장바구니 리스트 */
	public List<Cart> listAll(int ctmNo);

	/** 장바구니 상품 등록 */
	public void create(Cart cart);
	
	/** 장바구니 상품 조회 */
	public Cart read(int productCode, int ctmNo);
	
	/** 장바구니 상품 삭제 */
	public void delete(int productCode, int ctmNo);
	
	/** 상품 객체 반환 */
	public Product getProduct(int productCode);
	
}
