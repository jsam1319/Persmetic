package kr.or.kosta.leaf.search.dao;

import java.util.List;

import kr.or.kosta.leaf.product.domain.Product;

public interface SearchDao {

	public List<Product> listByKeyword(String keywordNames[]);
}
