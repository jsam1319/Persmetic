package kr.or.kosta.leaf.keyword.service;

import java.util.List;

import kr.or.kosta.leaf.keyword.domain.Keyword;

public interface KeywordService {

	
	public List<String> getKeywordNames(String keywordName) ;
	
	public void create(Keyword keyword);
}
