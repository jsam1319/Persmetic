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
	public void create(TotalOrder totalOrder);
	
	public TotalOrder read(int orderNo);
	
	public List<TotalOrder> listAll();
	
	public void delete(int orderNo);
	
//	public void update(int productCode, int imageNumber, ProductImage image);
	

}







