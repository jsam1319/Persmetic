package kr.or.kosta.leaf.product_answer.domain;

/**
 * 문의 답변을 위한 도메인 클래스
 *
 * @author 박연주
 *
 */

public class ProductAnswer {
	
	private int answerNo;
	private String answerTitle;
	private String answerContents;
	private String answerDate;
	private int inquiryNo;
	
	
	public ProductAnswer() {}
	
	public ProductAnswer(String answerTitle, String answerContents, int inquiryNo) {
		this(0, answerTitle, answerContents, null, inquiryNo);
	}
	
	public ProductAnswer(int answerNo, String answerTitle, String answerContents, String answerDate, int inquiryNo) {
		this.answerNo = answerNo;
		this.answerTitle = answerTitle;
		this.answerContents = answerContents;
		this.answerDate = answerDate;
		this.inquiryNo = inquiryNo;
	}

	public int getAnswerNo() {
		return answerNo;
	}

	public void setAnswerNo(int answerNo) {
		this.answerNo = answerNo;
	}

	public String getAnswerTitle() {
		return answerTitle;
	}

	public void setAnswerTitle(String answerTitle) {
		this.answerTitle = answerTitle;
	}

	public String getAnswerContents() {
		return answerContents;
	}

	public void setAnswerContents(String answerContents) {
		this.answerContents = answerContents;
	}

	public String getAnswerDate() {
		return answerDate;
	}

	public void setAnswerDate(String answerDate) {
		this.answerDate = answerDate;
	}

	public int getInquiryNo() {
		return inquiryNo;
	}

	public void setInquiryNo(int inquiryNo) {
		this.inquiryNo = inquiryNo;
	}
	
	
	

}
