package kr.or.kosta.leaf.test;
import static org.junit.Assert.*;

import org.junit.Test;

import kr.or.kosta.leaf.common.db.DaoFactory;
import kr.or.kosta.leaf.keyword.dao.JdbcKeywordDao;
import kr.or.kosta.leaf.keyword.dao.KeywordDao;
import kr.or.kosta.leaf.keyword.domain.Keyword;

public class JdbcKeywordDaoTest {

	DaoFactory factory = DaoFactory.getInstance();
	KeywordDao dao = (KeywordDao)factory.getDao(JdbcKeywordDao.class);
	
	@Test
	public void testCreate() {
		dao.create(new Keyword("테스트용", 1));
	}
	
}
