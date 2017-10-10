package kr.or.kosta.leaf.order_log.domain;

public class OrderLog {

	int productCode;
	String productName;
	int orderPrice;
	int orderCount;
	String OrderYN;
	String orderDate;
	String ctmName;
	
	
	
	public OrderLog() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderLog(int productCode, String productName, int orderPrice, int orderCount, String orderYN,
			String orderDate, String ctmName) {
		super();
		this.productCode = productCode;
		this.productName = productName;
		this.orderPrice = orderPrice;
		this.orderCount = orderCount;
		OrderYN = orderYN;
		this.orderDate = orderDate;
		this.ctmName = ctmName;
	}
	public int getProductCode() {
		return productCode;
	}
	public String getProductName() {
		return productName;
	}
	public int getOrderPrice() {
		return orderPrice;
	}
	public int getOrderCount() {
		return orderCount;
	}
	public String getOrderYN() {
		return OrderYN;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public String getCtmName() {
		return ctmName;
	}
	public void setProductCode(int productCode) {
		this.productCode = productCode;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public void setOrderPrice(int orderPrice) {
		this.orderPrice = orderPrice;
	}
	public void setOrderCount(int orderCount) {
		this.orderCount = orderCount;
	}
	public void setOrderYN(String orderYN) {
		OrderYN = orderYN;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public void setCtmName(String ctmName) {
		this.ctmName = ctmName;
	}
	@Override
	public String toString() {
		return "OrderList [productCode=" + productCode + ", productName=" + productName + ", orderPrice=" + orderPrice
				+ ", orderCount=" + orderCount + ", OrderYN=" + OrderYN + ", orderDate=" + orderDate + ", ctmName="
				+ ctmName + "]";
	}
	
	
}
