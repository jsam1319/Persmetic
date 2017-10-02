package kr.or.kosta.leaf.product_image.service;

import kr.or.kosta.leaf.common.db.DaoFactory;
import kr.or.kosta.leaf.product_image.dao.JdbcProductImageDao;
import kr.or.kosta.leaf.product_image.dao.ProductImageDao;
import kr.or.kosta.leaf.product_image.domain.ProductImage;

public class ProductImageServiceImpl implements ProductImageService {

	ProductImageDao productImageDao = (ProductImageDao)DaoFactory.getInstance().getDao(JdbcProductImageDao.class);
	
	@Override
	public void uploadImage(ProductImage productImage) {
		// TODO Auto-generated method stub
		
		productImageDao.create(productImage);
	}

}
