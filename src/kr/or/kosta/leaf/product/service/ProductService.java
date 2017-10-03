package kr.or.kosta.leaf.product.service;

import java.util.List;

import kr.or.kosta.leaf.common.web.Params;
import kr.or.kosta.leaf.product.domain.Product;

public interface ProductService {

	public void create(Product product);
	
	public List<Product> ListByParams(Params params); 
	
	public Product read(int productCode);
	
}
