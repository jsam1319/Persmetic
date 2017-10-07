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
import kr.or.kosta.leaf.review.domain.Review;
import kr.or.kosta.leaf.review.service.ReviewService;
import kr.or.kosta.leaf.review.service.ReviewServiceImpl;

public class ReviewDetailController implements Controller {

	ModelAndView mav = new ModelAndView();
	
	ReviewService reviewService = new ReviewServiceImpl();
	
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int reviewNo = Integer.parseInt(request.getParameter("review_no"));
		
		Review review = reviewService.read(reviewNo);
		
		mav.addObject("review", review);
		mav.setView("/detail.leaf");
		
		return mav;
	}

	
	
}
