package kr.or.kosta.leaf.product.service;

import java.util.List;

import kr.or.kosta.leaf.common.db.DaoFactory;
import kr.or.kosta.leaf.common.web.Params;
import kr.or.kosta.leaf.product.dao.JdbcProductDao;
import kr.or.kosta.leaf.product.dao.ProductDao;
import kr.or.kosta.leaf.product.domain.Product;

public class ProductServiceImpl implements ProductService {

	ProductDao productDao = (ProductDao)DaoFactory.getInstance().getDao(JdbcProductDao.class);
	
	@Override
	public void create(Product product) {
		productDao.create(product);
	}

	@Override
	public Product read(int productCode) {
		return productDao.read(productCode);
	}

	@Override
	public List<Product> ListByParams(Params params) {
		return productDao.listByParams(params);
	}
	
	@Override
	public int pageCount(Params params) {
		return productDao.pageCount(params);
	}
	
	
}
