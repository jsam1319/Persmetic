package kr.or.kosta.leaf.product.domain;

/**
 * 상품 정보와 등록을 위한 도메인 클래스
 * 
 * @author 박연주
 *
 */

public class ListDomain {
	private String productTone;
	private int categoryNo; 
	
	
	public ListDomain() {}
	
	public ListDomain(String productTone) {
		this(productTone, 0);
	}
	
	public ListDomain(int categoryNo) {
		this(null, categoryNo);
	}
	
	public ListDomain(String productTone, int categoryNo) {
		this.productTone = productTone;
		this.categoryNo = categoryNo;
	}

	public String getProductTone() {
		return productTone;
	}

	public void setProductTone(String productTone) {
		this.productTone = productTone;
	}

	public int getCategoryNo() {
		return categoryNo;
	}

	public void setCategoryNo(int categoryNo) {
		this.categoryNo = categoryNo;
	}

	@Override
	public String toString() {
		return "ListDomain [productTone=" + productTone + ", categoryNo=" + categoryNo + "]";
	}
	
	

	

}
