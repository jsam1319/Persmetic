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
	public void create(Cart cart);
	
	public Cart read(int productCode, int ctmNo);
	
	public List<Cart> listAll();
	
	public void delete(int productCode, int ctmNo);
	
//	public void update(int productCode, int imageNumber, ProductImage image);
	

}







