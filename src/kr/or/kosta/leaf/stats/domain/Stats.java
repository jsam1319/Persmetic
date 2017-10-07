package kr.or.kosta.leaf.stats.domain;

public class Stats {

	String orderDate;
	String productName;
	int orderCount;
	
	public Stats() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Stats(String orderDate, String productName, int orderCount) {
		super();
		this.orderDate = orderDate;
		this.productName = productName;
		this.orderCount = orderCount;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public String getProductName() {
		return productName;
	}
	public int getOrderCount() {
		return orderCount;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public void setOrderCount(int orderCount) {
		this.orderCount = orderCount;
	}
	
	@Override
	public String toString() {
		return "Stats [orderDate=" + orderDate + ", productName=" + productName + ", orderCount=" + orderCount + "]";
	}
}
