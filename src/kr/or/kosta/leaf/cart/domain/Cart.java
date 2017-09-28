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

	int product_code;
	int ctm_no;
	int cart_quanity;
	int cart_price;
	
	public Cart() {}
	
	public Cart(int product_code, int ctm_no, int cart_quanity, int cart_price) {
		super();
		this.product_code = product_code;
		this.ctm_no = ctm_no;
		this.cart_quanity = cart_quanity;
		this.cart_price = cart_price;
	}
	
	public int getProduct_code() {
		return product_code;
	}

	public void setProduct_code(int product_code) {
		this.product_code = product_code;
	}

	public int getCtm_no() {
		return ctm_no;
	}

	public void setCtm_no(int ctm_no) {
		this.ctm_no = ctm_no;
	}

	public int getCart_quanity() {
		return cart_quanity;
	}

	public void setCart_quanity(int cart_quanity) {
		this.cart_quanity = cart_quanity;
	}

	public int getCart_price() {
		return cart_price;
	}

	public void setCart_price(int cart_price) {
		this.cart_price = cart_price;
	}

	@Override
	public String toString() {
		return "Cart [product_code=" + product_code + ", ctm_no=" + ctm_no + ", cart_quanity=" + cart_quanity
				+ ", cart_price=" + cart_price + "]";
	}
}
