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

	int order_no;
	int product_code;
	int order_price;
	int order_count;

	public OrderItem() {}
	
	public OrderItem(int order_no, int product_code, int order_price, int order_count) {
		super();
		this.order_no = order_no;
		this.product_code = product_code;
		this.order_price = order_price;
		this.order_count = order_count;
	}

	public int getOrder_no() {
		return order_no;
	}

	public void setOrder_no(int order_no) {
		this.order_no = order_no;
	}

	public int getProduct_code() {
		return product_code;
	}

	public void setProduct_code(int product_code) {
		this.product_code = product_code;
	}

	public int getOrder_price() {
		return order_price;
	}

	public void setOrder_price(int order_price) {
		this.order_price = order_price;
	}

	public int getOrder_count() {
		return order_count;
	}

	public void setOrder_count(int order_count) {
		this.order_count = order_count;
	}

	@Override
	public String toString() {
		return "OrderItem [order_no=" + order_no + ", product_code=" + product_code + ", order_price=" + order_price
				+ ", order_count=" + order_count + "]";
	}

}
