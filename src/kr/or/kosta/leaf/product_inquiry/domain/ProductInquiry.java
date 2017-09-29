package kr.or.kosta.leaf.product_inquiry.domain;

/**
 * 상품 문의를 위한 도메인 클래스
 *
 * @author 박연주
 *
 */

public class ProductInquiry {
	private int inquiryNo;
	private String inquiryTitle;
	private String inquiryContents;
	private String inquiryDate;
	private int productCode;
	private int ctmNo;
	
	
	public ProductInquiry() {}
	
	public ProductInquiry(String inquiryTitle, String inquiryContents, int productCode, int ctmNo) {
		this(0, inquiryTitle, inquiryContents, null, productCode, ctmNo);
	}
	
	public ProductInquiry(int inquiryNo, String inquiryTitle, String inquiryContents, String inquiryDate, int productCode, int ctmNo) {
		this.inquiryNo = inquiryNo;
		this.inquiryTitle = inquiryTitle;
		this.inquiryContents = inquiryContents;
		this.inquiryDate = inquiryDate;
		this.productCode = productCode;
		this.ctmNo = ctmNo;
	}

	public int getInquiryNo() {
		return inquiryNo;
	}

	public void setInquiryNo(int inquiryNo) {
		this.inquiryNo = inquiryNo;
	}

	public String getInquiryTitle() {
		return inquiryTitle;
	}

	public void setInquiryTitle(String inquiryTitle) {
		this.inquiryTitle = inquiryTitle;
	}

	public String getInquiryContents() {
		return inquiryContents;
	}

	public void setInquiryContents(String inquiryContents) {
		this.inquiryContents = inquiryContents;
	}

	public String getInquiryDate() {
		return inquiryDate;
	}

	public void setInquiryDate(String inquiryDate) {
		this.inquiryDate = inquiryDate;
	}

	public int getProductCode() {
		return productCode;
	}

	public void setProductCode(int productCode) {
		this.productCode = productCode;
	}

	public int getCtmNo() {
		return ctmNo;
	}

	public void setCtmNo(int ctmNo) {
		this.ctmNo = ctmNo;
	}
	
	

}
