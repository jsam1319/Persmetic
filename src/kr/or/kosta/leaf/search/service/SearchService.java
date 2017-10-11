package kr.or.kosta.leaf.search.service;

import java.util.List;

import kr.or.kosta.leaf.product.domain.Product;

public interface SearchService {

	public List<Product> listByKeyword(String[] keywordNames);
}
