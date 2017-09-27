package kr.or.kosta.leaf.keyword.domain;

/**
 * Keyword 테이블의 매칭 Beans
 * 
 * ------ 2017-09-27------
 * 
 *
 * -----------------------
 * 
 * @author 이재현
 */

public class Keyword {
	String keywordName;
	int productCode;
	
	public Keyword() {}
	
	public Keyword(String keywordName, int productCode) {
		super();
		this.keywordName = keywordName;
		this.productCode = productCode;
	}
	
	public String getKeywordName() {
		return keywordName;
	}
	
	public int getProductCode() {
		return productCode;
	}
	
	public void setKeywordName(String keywordName) {
		this.keywordName = keywordName;
	}
	
	public void setProductCode(int productCode) {
		this.productCode = productCode;
	}
	
	@Override
	public String toString() {
		return "Keyword [keywordName=" + keywordName + ", productCode=" + productCode + "]";
	}
	
	
}
