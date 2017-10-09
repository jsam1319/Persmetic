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

public class ReviewCreateController implements Controller {

	ReviewService reviewService = new ReviewServiceImpl();
	ProductService productService = new ProductServiceImpl();
	ModelAndView mav = new ModelAndView();
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Review review = new Review();
		
		review.setCtmNo(Integer.parseInt(request.getParameter("ctmNo")));
		review.setProductCode(Integer.parseInt(request.getParameter("productCode")));
		review.setReviewGrade(Integer.parseInt(request.getParameter("grade")));
		review.setReviewTitle(request.getParameter("title"));
		review.setReviewContents(request.getParameter("content"));
		// review 사진등록
		System.out.println("리뷰타이틀:"+request.getParameter("title"));
		
		reviewService.create(review);
		
		return mav;
	}

}
