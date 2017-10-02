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

	int imageNo;
	String imageName;
	
	public ProductImage() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProductImage(int imageNo, String imageName) {
		super();
		this.imageNo = imageNo;
		this.imageName = imageName;
	}
	public int getImageNo() {
		return imageNo;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageNo(int imageNo) {
		this.imageNo = imageNo;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	
	
}
