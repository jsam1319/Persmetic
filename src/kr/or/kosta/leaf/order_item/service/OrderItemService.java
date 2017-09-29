package kr.or.kosta.leaf.order_item.service;

import java.util.List;

import kr.or.kosta.leaf.order_item.domain.OrderItem;

/**
 * Domain(업무영역)별 고객의 요구사항을 반영하는 비즈니스 메소드 선언
 * 
 * @author 손정화
 *
 */
public interface OrderItemService {
	
	/** 주문항목 등록 */
	public void create(OrderItem orderItem);
	
	/** 주문항목 조회 */
	public OrderItem read(int orderNo, int productCode);
	
	/** 주문항목 리스트 */
	public List<OrderItem> listAll(int orderNo);
	
	/** 주문항목 삭제 */
	public void delete(int orderNo, int productCode);
}
