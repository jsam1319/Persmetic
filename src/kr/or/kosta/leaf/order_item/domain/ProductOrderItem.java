package kr.or.kosta.leaf.order_item.domain;

/**
 * 
 * ProductName, Image를 포함하기 위한 
 * OrderItem 객체의 확장
 * 
 * 
 * 
 * @author 손정화
 *
 */

public class ProductOrderItem extends OrderItem {

	String productName;
	String productImage;
	int productPrice;

	
	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public ProductOrderItem() {
		super();
		productName = "";
	}

	public ProductOrderItem(int orderNo, int productCode, int orderPrice, int orderCount) {
		super(orderNo, productCode, orderPrice, orderCount);
	}

	public ProductOrderItem(int orderNo, int productCode, int orderPrice, int orderCount, String productName, String productImage , int productPrice) {
		super(orderNo, productCode, orderPrice, orderCount);
		this.productName = productName;
		this.productImage = productImage;
		this.productPrice = productPrice;
	}
	
	public ProductOrderItem(OrderItem orderitem, String productName, String productImage, int productPrice) {
		this(orderitem.orderNo, orderitem.productCode, orderitem.orderPrice, orderitem.orderCount, productName, productImage, productPrice);
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	@Override
	public String toString() {
		return "ProductOrderItem [productName=" + productName + ", productImage=" + productImage + ", productPrice="
				+ productPrice + "]";
	}
	
	
}
