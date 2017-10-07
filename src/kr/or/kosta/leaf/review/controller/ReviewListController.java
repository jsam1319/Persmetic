package kr.or.kosta.leaf.review.controller;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosta.leaf.common.controller.Controller;
import kr.or.kosta.leaf.common.controller.ModelAndView;
import kr.or.kosta.leaf.common.web.PageBuilder;
import kr.or.kosta.leaf.common.web.Params;
import kr.or.kosta.leaf.product.domain.Product;
import kr.or.kosta.leaf.product.service.ProductService;
import kr.or.kosta.leaf.product.service.ProductServiceImpl;
import kr.or.kosta.leaf.review.domain.Review;
import kr.or.kosta.leaf.review.service.ReviewService;
import kr.or.kosta.leaf.review.service.ReviewServiceImpl;

public class ReviewListController implements Controller {

	ModelAndView mav = new ModelAndView();
	ReviewService service = new ReviewServiceImpl();
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String pageNo = request.getParameter("page");
			if(pageNo==null) pageNo="1";
		int page = Integer.parseInt(pageNo);
		
		Params params = new Params(page, null, null, 5, 5);
		List<Review> reviews = service.listByPage(page);
		
		int totalRowCount = service.pageCount(params);
		PageBuilder pageBuilder = new PageBuilder(params, totalRowCount);
		pageBuilder.build();
		
		mav.addObject("list", reviews);
		mav.addObject("pageBuilder", pageBuilder);
		mav.setView("detail.leaf");
		
		return mav;
	}
}