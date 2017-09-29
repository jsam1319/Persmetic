package kr.or.kosta.leaf.total_order.service;

import java.util.List;

import kr.or.kosta.leaf.total_order.domain.TotalOrder;

/**
 * Domain(업무영역)별 고객의 요구사항을 반영하는 비즈니스 메소드 선언
 * 
 * @author 손정화
 *
 */
public interface TotalOrderService {
	
	/** 주문 상품 등록 */
	public void create(TotalOrder totalOrder);
	
	/** 주문 상품 조회 */
	public TotalOrder read(int orderNo);
	
	/** 주문 상품 리스트 */
	public List<TotalOrder> listAll();
	
	/** 주문 전 상품 삭제 */
	public void delete(int orderNo);
}
