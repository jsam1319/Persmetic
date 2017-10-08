package kr.or.kosta.leaf.review.controller;

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

public class ReviewActionController implements Controller{
	
	ProductService productService = new ProductServiceImpl();
	ModelAndView mav = new ModelAndView();
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int productCode = Integer.parseInt(request.getParameter("productCode"));
		
		Product product = productService.read(productCode);
		
		mav.addObject("product", product);
		mav.setView("review.leaf");
		
		return mav;

}
}