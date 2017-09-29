package kr.or.kosta.leaf.order_item.dao;

import java.util.List;

import kr.or.kosta.leaf.order_item.domain.OrderItem;

/**
 * order_item 테이블 매칭 Dao Interface
 * 
 * ------ 2017-09-28------
 * 
 * -----------------------
 * 
 * @author 손정화
 */

public interface OrderItemDao {
	/* DB CRUD*/
	/** 주문항목 등록 */
	public void create(OrderItem orderItem);
	
	/** 주문항목 조회 */
	public OrderItem read(int orderNo, int productCode);
	
	/** 주문항목 리스트 */
	public List<OrderItem> listAll(int orderNo);
	
	/** 주문항목 삭제 */
	public void delete(int orderNo, int productCode);
}







