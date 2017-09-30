package kr.or.kosta.leaf.cart.service;

/**
 * ****************************
 * 2017-09-30 - 이재현
 * ProductCart로 변경(Cart 객체)
 * 상품 명 검색 메소드 추가(ProductDao 의존관계 추가)
 * *****************************
 * 
 */


import java.util.List;

import kr.or.kosta.leaf.cart.dao.CartDao;
import kr.or.kosta.leaf.cart.dao.JdbcCartDao;
import kr.or.kosta.leaf.cart.domain.Cart;
import kr.or.kosta.leaf.common.db.DaoFactory;
import kr.or.kosta.leaf.product.dao.JdbcProductDao;
import kr.or.kosta.leaf.product.dao.ProductDao;
import kr.or.kosta.leaf.product.domain.Product;

public class CartServiceImpl implements CartService {
	
	CartDao cartDao = (CartDao)DaoFactory.getInstance().getDao(JdbcCartDao.class);
	/* 상품 명을 가져오기 위한 ProductDao 선언 */
	ProductDao productDao = (ProductDao)DaoFactory.getInstance().getDao(JdbcProductDao.class);
	
	@Override
	public List<Cart> listAll(int ctmNo) {
		return cartDao.listAll(ctmNo);
	}
	
	@Override
	public void create(Cart cart) {
		cartDao.create(cart);
	}

	@Override
	public Cart read(int productCode, int ctmNo) {
		return cartDao.read(productCode, ctmNo);
	}
	
	@Override
	public void delete(int productCode, int ctmNo) {
		cartDao.delete(productCode, ctmNo);
	}

	@Override
	public Product getProduct(int productCode) {
		// TODO Auto-generated method stub
		return productDao.read(productCode);
	}
	
	
	
/*	public static void main(String[] args) {
		CartService service = new CartServiceImpl();
		List<Cart> list = service.listAll(2);	//파라미터 ctmNo
		System.out.println(list);
	}*/
}







