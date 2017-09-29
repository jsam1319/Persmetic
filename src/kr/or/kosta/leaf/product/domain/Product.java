package kr.or.kosta.leaf.product.domain;

/**
 * 상품 정보와 등록을 위한 도메인 클래스
 * 
 * @author 박연주
 *
 */

public class Product {
	private int productCode;
	private String productName;
	private String productExplain;
	private String productBrand;
	private String productTone;
	private String productColor;
	private int productPrice;
	private int productSow;
	private int productHits;
	private int categoryNo; 
	private String productImage;
	
	
	public Product() {}
	
	public Product(int productCode, String productName, String productExplain, String productBrand, String productColor,  String productTone,int productPrice, int productSow) {
		this(productCode, productName, productExplain, productBrand, productColor, productTone, productPrice, productSow, 0, 1, null);
	}
	
	public Product(int productCode, String productName, String productExplain, String productBrand, String productColor, String productTone, int productPrice, int productSow, int productHits, int categoryNo, String productImage) {
		this.productCode = productCode;
		this.productName = productName;
		this.productExplain= productExplain;
		this.productBrand = productBrand;
		this.productTone = productTone;
		this.productColor = productColor;
		this.productPrice = productPrice;
		this.productSow = productSow;
		this.productHits = productHits;
		this.categoryNo = categoryNo;
		this.productImage = productImage;
	}

	public int getProductCode() {
		return productCode;
	}

	public void setProductCode(int productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductExplain() {
		return productExplain;
	}

	public void setProductExplain(String productExplain) {
		this.productExplain = productExplain;
	}

	public String getProductBrand() {
		return productBrand;
	}

	public void setProductBrand(String productBrand) {
		this.productBrand = productBrand;
	}

	public String getProductTone() {
		return productTone;
	}

	public void setProductTone(String productTone) {
		this.productTone = productTone;
	}

	public String getProductColor() {
		return productColor;
	}

	public void setProductColor(String productColor) {
		this.productColor = productColor;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public int getProductSow() {
		return productSow;
	}

	public void setProductSow(int productSow) {
		this.productSow = productSow;
	}

	public int getProductHits() {
		return productHits;
	}

	public void setProductHits(int productHits) {
		this.productHits = productHits;
	}

	public int getCategoryNo() {
		return categoryNo;
	}

	public void setCategoryNo(int categoryNo) {
		this.categoryNo = categoryNo;
	}

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}
	
	
	

}
