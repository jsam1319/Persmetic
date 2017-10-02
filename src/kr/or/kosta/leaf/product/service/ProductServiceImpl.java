package kr.or.kosta.leaf.product.service;

import kr.or.kosta.leaf.common.db.DaoFactory;
import kr.or.kosta.leaf.product.dao.JdbcProductDao;
import kr.or.kosta.leaf.product.dao.ProductDao;
import kr.or.kosta.leaf.product.domain.Product;

public class ProductServiceImpl implements ProductService {

	ProductDao productDao = (ProductDao)DaoFactory.getInstance().getDao(JdbcProductDao.class);
	
	@Override
	public void create(Product product) {
		// TODO Auto-generated method stub

		productDao.create(product);
	}

}
