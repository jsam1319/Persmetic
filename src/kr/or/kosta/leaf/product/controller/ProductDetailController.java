package kr.or.kosta.leaf.product.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosta.leaf.common.controller.Controller;
import kr.or.kosta.leaf.common.controller.ModelAndView;
import kr.or.kosta.leaf.product.domain.Product;
import kr.or.kosta.leaf.product.service.ProductService;
import kr.or.kosta.leaf.product.service.ProductServiceImpl;
import kr.or.kosta.leaf.review.service.ReviewService;
import kr.or.kosta.leaf.review.service.ReviewServiceImpl;

public class ProductDetailController implements Controller {

	ModelAndView mav = new ModelAndView();

	ProductService productService = new ProductServiceImpl();
	ReviewService reviewService = new ReviewServiceImpl();

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/** product Info */
		int productCode = Integer.parseInt(request.getParameter("product_code"));
		
		Product product = productService.read(productCode);
		String grade = product.getGrade();
		
		if(grade == null) grade="0";
		System.out.println("product:"+grade);

		mav.addObject("product", product);
		mav.setView("/detail.leaf");
		
		
		System.out.println(product.toString());
		return mav;
	}

}
