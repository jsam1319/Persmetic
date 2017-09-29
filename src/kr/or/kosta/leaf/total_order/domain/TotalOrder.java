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

	int orderNo;
	int orderTotalprice;
	String orderAddress;
	String orderRecipient;
	String orderDate;
	String orderPayoption;
	String orderYn;
	int ctmNo;
	
	public TotalOrder() {}
	
	public TotalOrder(int orderNo, int orderTotalprice, String orderAddress, String orderRecipient, String orderDate,
			String orderPayoption, String orderYn, int ctmNo) {
		super();
		this.orderNo = orderNo;
		this.orderTotalprice = orderTotalprice;
		this.orderAddress = orderAddress;
		this.orderRecipient = orderRecipient;
		this.orderDate = orderDate;
		this.orderPayoption = orderPayoption;
		this.orderYn = orderYn;
		this.ctmNo = ctmNo;
	}

	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	public int getOrderTotalprice() {
		return orderTotalprice;
	}

	public void setOrderTotalprice(int orderTotalprice) {
		this.orderTotalprice = orderTotalprice;
	}

	public String getOrderAddress() {
		return orderAddress;
	}

	public void setOrderAddress(String orderAddress) {
		this.orderAddress = orderAddress;
	}

	public String getOrderRecipient() {
		return orderRecipient;
	}

	public void setOrderRecipient(String orderRecipient) {
		this.orderRecipient = orderRecipient;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getOrderPayoption() {
		return orderPayoption;
	}

	public void setOrderPayoption(String orderPayoption) {
		this.orderPayoption = orderPayoption;
	}

	public String getOrderYn() {
		return orderYn;
	}

	public void setOrderYn(String orderYn) {
		this.orderYn = orderYn;
	}

	public int getCtmNo() {
		return ctmNo;
	}

	public void setCtmNo(int ctmNo) {
		this.ctmNo = ctmNo;
	}

	@Override
	public String toString() {
		return "TotalOrder [orderNo=" + orderNo + ", orderTotalprice=" + orderTotalprice + ", orderAddress="
				+ orderAddress + ", orderRecipient=" + orderRecipient + ", orderDate=" + orderDate + ", orderPayoption="
				+ orderPayoption + ", orderYn=" + orderYn + ", ctmNo=" + ctmNo + "]";
	}
}
