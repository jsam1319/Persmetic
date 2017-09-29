package kr.or.kosta.leaf.cart.service;

import java.util.List;

import kr.or.kosta.leaf.cart.dao.CartDao;
import kr.or.kosta.leaf.cart.dao.JdbcCartDao;
import kr.or.kosta.leaf.cart.domain.Cart;
import kr.or.kosta.leaf.common.db.DaoFactory;

public class CartServiceImpl implements CartService {
	
	CartDao cartDao = (CartDao)DaoFactory.getInstance().getDao(JdbcCartDao.class);
	
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
	
	public static void main(String[] args) {
		CartService service = new CartServiceImpl();
		List<Cart> list = service.listAll(2);	//파라미터 ctmNo
		System.out.println(list);
	}
}







