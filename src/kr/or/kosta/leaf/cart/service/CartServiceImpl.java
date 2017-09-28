package kr.or.kosta.leaf.cart.service;

import java.util.List;

import kr.or.kosta.leaf.cart.dao.CartDao;
import kr.or.kosta.leaf.cart.dao.JdbcCartDao;
import kr.or.kosta.leaf.cart.domain.Cart;
import kr.or.kosta.leaf.common.db.DaoFactory;

public class CartServiceImpl implements CartService {
	
	private static int ctm_no;
	CartDao cartDao = (CartDao)DaoFactory.getInstance().getDao(JdbcCartDao.class);
	
	@Override
	public List<Cart> listAll(int ctm_no) {
		return cartDao.listAll(ctm_no);
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
		List<Cart> list = service.listAll(ctm_no);
		System.out.println(list);
	}
}







