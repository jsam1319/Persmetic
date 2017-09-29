package kr.or.kosta.leaf.order_item.domain;

/**
 * 주문항목 기능을 위한 도메인 클래스
 * 
 * ------ 2017-09-28------
 * 
 * -----------------------
 * 
 * @author 손정화
 */

public class OrderItem {

	int orderNo;
	int productCode;
	int orderPrice;
	int orderCount;

	public OrderItem() {}
	
	public OrderItem(int orderNo, int productCode, int orderPrice, int orderCount) {
		super();
		this.orderNo = orderNo;
		this.productCode = productCode;
		this.orderPrice = orderPrice;
		this.orderCount = orderCount;
	}

	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	public int getProductCode() {
		return productCode;
	}

	public void setProductCode(int productCode) {
		this.productCode = productCode;
	}

	public int getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(int orderPrice) {
		this.orderPrice = orderPrice;
	}

	public int getOrderCount() {
		return orderCount;
	}

	public void setOrderCount(int orderCount) {
		this.orderCount = orderCount;
	}

	@Override
	public String toString() {
		return "OrderItem [orderNo=" + orderNo + ", productCode=" + productCode + ", orderPrice=" + orderPrice
				+ ", orderCount=" + orderCount + "]";
	}

}
