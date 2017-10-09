package kr.or.kosta.leaf.review.domain;

/**
 * 리뷰 등록을 위한 도메인 클래스
 * 
 * @author 박연주
 *
 */

public class Review {
	
	private int reviewNo;
	private int ctmNo;
	private int productCode;
	private int reviewGrade;
	private String reviewTitle;
	private String reviewContents;
	private String reviewDate;
	private String ctmId;
	private String productName;
	

	
	public Review() {}
	
	public Review(int ctmNo, int productCode, int reviewGrade, String reviewTitle, String reviewContents) {
		this(0, ctmNo, productCode, reviewGrade, reviewTitle, reviewContents, null, null, null);
	}
	
	public Review(int reviewNo, int ctmNo, int productCode, int reviewGrade, String reviewTitle, String reviewContents, String reviewDate, String ctmId, String productName) {
		this.reviewNo = reviewNo;
		this.ctmNo = ctmNo;
		this.productCode = productCode;
		this.reviewGrade = reviewGrade;
		this.reviewTitle = reviewTitle;
		this.reviewContents = reviewContents;
		this.reviewDate = reviewDate;
		this.ctmId = ctmId;
		this.productName = productName;
	}

	
	public int getReviewNo() {
		return reviewNo;
	}

	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}

	public int getCtmNo() {
		return ctmNo;
	}

	public void setCtmNo(int ctmNo) {
		this.ctmNo = ctmNo;
	}

	public int getProductCode() {
		return productCode;
	}

	public void setProductCode(int productCode) {
		this.productCode = productCode;
	}

	public int getReviewGrade() {
		return reviewGrade;
	}

	public void setReviewGrade(int reviewGrade) {
		this.reviewGrade = reviewGrade;
	}

	public String getReviewTitle() {
		return reviewTitle;
	}

	public void setReviewTitle(String reviewTitle) {
		this.reviewTitle = reviewTitle;
	}

	public String getReviewContents() {
		return reviewContents;
	}

	public void setReviewContents(String reviewContents) {
		this.reviewContents = reviewContents;
	}

	public String getReviewDate() {
		return reviewDate;
	}

	public void setReviewDate(String reviewDate) {
		this.reviewDate = reviewDate;
	}

	public String getCtmId() {
		return ctmId;
	}

	public void setCtmId(String ctmId) {
		this.ctmId = ctmId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	@Override
	public String toString() {
		return "Review [reviewNo=" + reviewNo + ", ctmNo=" + ctmNo + ", productCode=" + productCode + ", reviewGrade="
				+ reviewGrade + ", reviewTitle=" + reviewTitle + ", reviewContents=" + reviewContents + ", reviewDate="
				+ reviewDate + ", ctmId=" + ctmId + ", productName=" + productName + "]";
	}
	
	

}
