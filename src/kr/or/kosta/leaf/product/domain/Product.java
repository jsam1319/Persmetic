package kr.or.kosta.leaf.product.domain;

/**
 * 상품 정보와 등록을 위한 도메인 클래스
 * 
 * @author 박연주
 *
 */

public class Product {
	private int product_code;
	private String product_name;
	private String product_explain;
	private String product_brand;
	private String product_tone;
	private String product_color;
	private int product_price;
	private int product_sow;
	private int product_hits;
	private int category_no;
	
	
	
	public Product() {}
	
	public Product(int product_code, String product_name, String product_explain, String product_brand, String product_tone, String product_color, int product_price, int product_sow) {
		this(product_code, product_name, product_explain, product_brand, product_tone, product_color, product_price, product_sow, 0, 0);
	}
	
	public Product(int product_code, String product_name, String product_explain, String product_brand, String product_tone,String product_color, int product_price, int product_sow, int category_no) {
		this(product_code, product_name, product_explain, product_brand, product_tone, product_color, product_price, product_sow, 0, category_no);
	}
	
	public Product(int product_code, String product_name, String product_explain, String product_brand, String product_tone, String product_color, int product_price, int product_sow, int product_hits, int category_no) {
		this.product_code = product_code;
		this.product_name = product_name;
		this.product_explain= product_explain;
		this.product_brand = product_brand;
		this.product_tone = product_tone;
		this.product_color = product_color;
		this.product_price = product_price;
		this.product_sow = product_sow;
		this.product_hits = product_hits;
		this.category_no = category_no;
	}
	
	
	public int getProduct_code() {
		return product_code;
	}
	public void setProduct_code(int product_code) {
		this.product_code = product_code;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getProduct_explain() {
		return product_explain;
	}
	public void setProduct_explain(String product_explain) {
		this.product_explain = product_explain;
	}
	public String getProduct_brand() {
		return product_brand;
	}
	public void setProduct_brand(String product_brand) {
		this.product_brand = product_brand;
	}
	public String getProduct_tone() {
		return product_tone;
	}
	public void setProduct_tone(String product_tone) {
		this.product_tone = product_tone;
	}
	public String getProduct_color() {
		return product_color;
	}
	public void setProduct_color(String product_color) {
		this.product_color = product_color;
	}
	public int getProduct_price() {
		return product_price;
	}
	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}
	public int getProduct_sow() {
		return product_sow;
	}
	public void setProduct_sow(int product_sow) {
		this.product_sow = product_sow;
	}
	public int getProduct_hits() {
		return product_hits;
	}
	public void setProduct_hits(int product_hits) {
		this.product_hits = product_hits;
	}
	public int getCategory_no() {
		return category_no;
	}
	public void setCategory_no(int category_no) {
		this.category_no = category_no;
	}
	

}
