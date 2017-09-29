package kr.or.kosta.leaf.cart.domain;

/**
 * 장바구니 기능을 위한 도메인 클래스
 * 
 * ------ 2017-09-28------
 * 
 * -----------------------
 * 
 * @author 손정화
 */

public class Cart {

	int productCode;
	int ctmNo;
	int cartQuantity;
	int cartPrice;
	
	public Cart() {}
	
	public Cart(int productCode, int ctmNo, int cartQuantity, int cartPrice) {
		super();
		this.productCode = productCode;
		this.ctmNo = ctmNo;
		this.cartQuantity = cartQuantity;
		this.cartPrice = cartPrice;
	}

	public int getProductCode() {
		return productCode;
	}

	public void setProductCode(int productCode) {
		this.productCode = productCode;
	}

	public int getCtmNo() {
		return ctmNo;
	}

	public void setCtmNo(int ctmNo) {
		this.ctmNo = ctmNo;
	}

	public int getCartQuantity() {
		return cartQuantity;
	}

	public void setCartQuantity(int cartQuantity) {
		this.cartQuantity = cartQuantity;
	}

	public int getCartPrice() {
		return cartPrice;
	}

	public void setCartPrice(int cartPrice) {
		this.cartPrice = cartPrice;
	}

	@Override
	public String toString() {
		return "Cart [productCode=" + productCode + ", ctmNo=" + ctmNo + ", cartQuantity=" + cartQuantity
				+ ", cartPrice=" + cartPrice + "]";
	}
	
}
