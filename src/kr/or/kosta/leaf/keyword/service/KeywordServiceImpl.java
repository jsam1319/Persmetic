package kr.or.kosta.leaf.keyword.service;

import java.util.List;

import kr.or.kosta.leaf.common.db.DaoFactory;
import kr.or.kosta.leaf.keyword.dao.JdbcKeywordDao;
import kr.or.kosta.leaf.keyword.dao.KeywordDao;
import kr.or.kosta.leaf.keyword.domain.Keyword;

public class KeywordServiceImpl implements KeywordService {
	KeywordDao keywordDao = (KeywordDao)DaoFactory.getInstance().getDao(JdbcKeywordDao.class);
	
	public List<String> getKeywordNames(String keywordName) {
		return keywordDao.getKeywordNames(keywordName);
	}
	
	public void create(Keyword keyword) {
		keywordDao.create(keyword);
	}
	
	public void plusHitCount(String keywordName) {
		keywordDao.plusHitCount(keywordName);
	}
	
	public List<Keyword> getKeyword(int productCode) {
		return keywordDao.getKeywords(productCode);
	}
}
