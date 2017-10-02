package kr.or.kosta.leaf.product_image.service;

import kr.or.kosta.leaf.product_image.domain.ProductImage;

/**
 * 제품 이미지를 업로드 하는 서비스
 * 인터페이스
 * @author 이재현
 *
 */

public interface ProductImageService {

	/* 이미지를 업로드 */
	public void uploadImage(ProductImage productImage);
	
}
