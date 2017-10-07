package kr.or.kosta.leaf.keyword.service;

import java.util.List;

import kr.or.kosta.leaf.common.db.DaoFactory;
import kr.or.kosta.leaf.keyword.dao.JdbcKeywordDao;
import kr.or.kosta.leaf.keyword.dao.KeywordDao;

public class KeywordService {

	KeywordDao keywordDao = (KeywordDao)DaoFactory.getInstance().getDao(JdbcKeywordDao.class);
	
	public List<String> getKeywordNames(String keywordName) {
		return keywordDao.getKeywordNames(keywordName);
	}
}
