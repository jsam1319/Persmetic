package kr.or.kosta.leaf.total_order.dao;

import java.util.List;

import kr.or.kosta.leaf.total_order.domain.TotalOrder;

/**
 * total_order 테이블 매칭 Dao Interface
 * 
 * ------ 2017-09-28------
 * 
 * -----------------------
 * 
 * @author 손정화
 */

public interface TotalOrderDao {
	/* DB CRUD*/
	/** 주문 상품 등록 */
	public void create(TotalOrder totalOrder);
	
	/** 주문 상품 조회 */
	public TotalOrder read(int orderNo);
	
	/** 주문 상품 리스트 */
	public List<TotalOrder> listAll();
	
	/** 주문 전 상품 삭제 */
	public void delete(int orderNo);
	
}






