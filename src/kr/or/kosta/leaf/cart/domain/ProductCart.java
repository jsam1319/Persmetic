package kr.or.kosta.leaf.cart.domain;

/**
 * 
 * ProductName, Image를 포함하기 위한 
 * Cart 객체의 확장
 * 
 * 
 * 
 * @author 이재현
 *
 */

public class ProductCart extends Cart {

	String productName;
	String productImage;

	
	
	public ProductCart() {
		super();
		productName = "";
	}

	public ProductCart(int productCode, int ctmNo, int cartQuantity, int cartPrice, int cartNo) {
		super(productCode, ctmNo, cartQuantity, cartPrice, cartNo);
	}

	public ProductCart(int productCode, int ctmNo, int cartQuantity, int cartPrice, int cartNo, String productName, String productImage) {
		super(productCode, ctmNo, cartQuantity, cartPrice, cartNo);
		this.productName = productName;
		this.productImage = productImage;
	}
	
	public ProductCart(Cart cart, String productName, String productImage)  {
		this(cart.productCode, cart.ctmNo, cart.cartQuantity, cart.cartPrice, cart.cartNo, productName, productImage);
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
	
	
}
