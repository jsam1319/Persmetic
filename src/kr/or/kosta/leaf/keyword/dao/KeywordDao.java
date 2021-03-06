package kr.or.kosta.leaf.keyword.dao;

import java.util.List;

import kr.or.kosta.leaf.keyword.domain.Keyword;
import kr.or.kosta.leaf.product.domain.Product;


/**
 * 검색, 추천 시 더욱 정확하고 빠른 정보를 제공하기 위한 
 * Keyword 테이블 매칭 Dao Interface
 * 
 * ------ 2017-09-27------
 * 
 * 
 * -----------------------
 * 
 * @author 이재현
 */
public interface KeywordDao {
	
	/* DB CRUD*/
	public void create(Keyword keyword);
	
	public List<String> getKeywordNames(String keywordName);
	
	public Keyword read(String keywordName, int productCode);
	
	public void delete(String keywordName, int productCode);
	
	public void plusHitCount(String keywordName);

	List<Keyword> getKeywords(int productCode);
	
}







