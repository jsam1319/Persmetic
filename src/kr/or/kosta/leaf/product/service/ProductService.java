package kr.or.kosta.leaf.product.service;

import java.util.List;

import kr.or.kosta.leaf.common.web.Params;
import kr.or.kosta.leaf.product.domain.Product;

public interface ProductService {

	public void create(Product product);
	
	public Product read(int productCode);
	
	public List<Product> listByParams(Params params, int categoryNo); 
	
	public int pageCount(Params params);
	
	public int getMaxProductCode();
	
	public List<Product> listAll();
	
}
