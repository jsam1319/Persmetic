package kr.or.kosta.leaf.search.service;

import java.util.List;

import kr.or.kosta.leaf.common.db.DaoFactory;
import kr.or.kosta.leaf.product.domain.Product;
import kr.or.kosta.leaf.search.dao.JdbcSearchDao;
import kr.or.kosta.leaf.search.dao.SearchDao;

public class SearchServiceImpl implements SearchService {

	SearchDao searchDao = (SearchDao)DaoFactory.getInstance().getDao(JdbcSearchDao.class);
	
	@Override
	public List<Product> listByKeyword(String[] keywordNames) {
		// TODO Auto-generated method stub
		return searchDao.listByKeyword(keywordNames);
	}

}
