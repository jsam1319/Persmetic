package kr.or.kosta.leaf.total_order.domain;

/**
 * 주문 기능을 위한 도메인 클래스
 * 
 * ------ 2017-09-28------
 * 
 * -----------------------
 * 
 * @author 손정화
 */

public class TotalOrder {

	int order_no;
	int order_totalprice;
	String order_address;
	String order_recipient;
	String order_date;
	String order_payoption;
	String order_yn;
	int ctm_no;
	
	public TotalOrder() {}
	
	public TotalOrder(int order_no, int order_totalprice, String order_address, String order_recipient,
			String order_date, String order_payoption, String order_yn, int ctm_no) {
		super();
		this.order_no = order_no;
		this.order_totalprice = order_totalprice;
		this.order_address = order_address;
		this.order_recipient = order_recipient;
		this.order_date = order_date;
		this.order_payoption = order_payoption;
		this.order_yn = order_yn;
		this.ctm_no = ctm_no;
	}

	public int getOrder_no() {
		return order_no;
	}

	public void setOrder_no(int order_no) {
		this.order_no = order_no;
	}

	public int getOrder_totalprice() {
		return order_totalprice;
	}

	public void setOrder_totalprice(int order_totalprice) {
		this.order_totalprice = order_totalprice;
	}

	public String getOrder_address() {
		return order_address;
	}

	public void setOrder_address(String order_address) {
		this.order_address = order_address;
	}

	public String getOrder_recipient() {
		return order_recipient;
	}

	public void setOrder_recipient(String order_recipient) {
		this.order_recipient = order_recipient;
	}

	public String getOrder_date() {
		return order_date;
	}

	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}

	public String getOrder_payoption() {
		return order_payoption;
	}

	public void setOrder_payoption(String order_payoption) {
		this.order_payoption = order_payoption;
	}

	public String getOrder_yn() {
		return order_yn;
	}

	public void setOrder_yn(String order_yn) {
		this.order_yn = order_yn;
	}

	public int getCtm_no() {
		return ctm_no;
	}

	public void setCtm_no(int ctm_no) {
		this.ctm_no = ctm_no;
	}

	@Override
	public String toString() {
		return "TotalOrder [order_no=" + order_no + ", order_totalprice=" + order_totalprice + ", order_address="
				+ order_address + ", order_recipient=" + order_recipient + ", order_date=" + order_date
				+ ", order_payoption=" + order_payoption + ", order_yn=" + order_yn + ", ctm_no=" + ctm_no + "]";
	}

}
