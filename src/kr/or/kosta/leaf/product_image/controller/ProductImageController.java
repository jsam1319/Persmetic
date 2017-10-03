package kr.or.kosta.leaf.product_image.controller;

import java.io.IOException;
import java.io.PrintWriter;

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
		System.out.println("image : " + request.getParameter("image_name"));
		ProductImage productImage = new ProductImage(-1, request.getParameter("image_name"));		
		
		FileUpload.uploadFile(request);
		productImageService.uploadImage(productImage);

		return null;
	}

}
