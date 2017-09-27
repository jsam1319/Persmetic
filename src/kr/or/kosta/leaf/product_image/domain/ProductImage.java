package kr.or.kosta.leaf.product_image.domain;

/**
 * 상품 등록 시 이미지를 등록하기 위한 도메인 클래스
 * product_image와 매칭
 * 
 * ------ 2017-09-27------
 * 
 * 
 * -----------------------
 * 
 * @author 이재현
 */

public class ProductImage {

	int productCode;
	int imageNumber;
	String imageName;
	String imageFront;
	
	public ProductImage(int productCode, int imageNumber, String imageName, String imageFront) {
		super();
		this.productCode = productCode;
		this.imageNumber = imageNumber;
		this.imageName = imageName;
		this.imageFront = imageFront;
	}
	public ProductImage() {

	}
	
	public int getProductCode() {
		return productCode;
	}
	public int getImageNumber() {
		return imageNumber;
	}
	public String getImageName() {
		return imageName;
	}
	public String getImageFront() {
		return imageFront;
	}
	public void setProductCode(int productCode) {
		this.productCode = productCode;
	}
	public void setImageNumber(int imageNumber) {
		this.imageNumber = imageNumber;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public void setImageFront(String imageFront) {
		this.imageFront = imageFront;
	}
	
	@Override
	public String toString() {
		return "ProductImage [productCode=" + productCode + ", imageNumber=" + imageNumber + ", imageName=" + imageName
				+ ", imageFront=" + imageFront + "]";
	}

	
	
}
