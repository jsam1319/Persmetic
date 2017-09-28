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
	public void create(OrderItem orderItem);
	
	public OrderItem read(int orderNo, int productCode);
	
	public List<OrderItem> listAll();
	
	public void delete(int orderNo, int productCode);
	
//	public void update(int productCode, int imageNumber, ProductImage image);
	

}







