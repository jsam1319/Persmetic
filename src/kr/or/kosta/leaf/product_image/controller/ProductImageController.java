package kr.or.kosta.leaf.product_image.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosta.leaf.common.controller.Controller;
import kr.or.kosta.leaf.common.controller.ModelAndView;
import kr.or.kosta.leaf.product_image.domain.ProductImage;
import kr.or.kosta.leaf.product_image.service.ProductImageService;
import kr.or.kosta.leaf.product_image.service.ProductImageServiceImpl;

public class ProductImageController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ProductImageService productImageService = new ProductImageServiceImpl();
		
		String path = FileUpload.uploadFile(request);
		String fileName = (String) request.getAttribute("fileName");
		System.out.println(path);
		System.out.println("Controller.fileName : " + fileName);
		
		/* 이미지 번호와 파일 이름 */
		ProductImage productImage = new ProductImage(-1, fileName);		
		
		productImageService.uploadImage(productImage);
		response.getWriter().println(path);

		return null;
	}

}
