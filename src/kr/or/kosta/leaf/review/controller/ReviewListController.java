package kr.or.kosta.leaf.review.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import kr.or.kosta.leaf.common.controller.Controller;
import kr.or.kosta.leaf.common.controller.ModelAndView;
import kr.or.kosta.leaf.common.web.PageBuilder;
import kr.or.kosta.leaf.common.web.Params;
import kr.or.kosta.leaf.customer.domain.Customer;
import kr.or.kosta.leaf.customer.service.CustomerService;
import kr.or.kosta.leaf.customer.service.CustomerServiceImpl;
import kr.or.kosta.leaf.product.domain.Product;
import kr.or.kosta.leaf.product.service.ProductService;
import kr.or.kosta.leaf.product.service.ProductServiceImpl;
import kr.or.kosta.leaf.review.domain.Review;
import kr.or.kosta.leaf.review.service.ReviewService;
import kr.or.kosta.leaf.review.service.ReviewServiceImpl;

public class ReviewListController implements Controller {

	ModelAndView mav = new ModelAndView();
	ReviewService reviewService = new ReviewServiceImpl();

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");

		int productCode = Integer.parseInt(request.getParameter("product_code"));
		
		
		/** 페이징 */
		String pageNo = request.getParameter("page");
		if (pageNo == null)
			pageNo = "1";
		int page = Integer.parseInt(pageNo);
		
		Params params = new Params(page, null, null, 5, 5);
		
		int totalRowCount = reviewService.pageCount(params, productCode);
		
		List<Review> reviews = reviewService.listByParams(params, productCode);
		PageBuilder pageBuilder = new PageBuilder(params, totalRowCount);

		/** JSON */
		JSONObject totalObj = new JSONObject();
		JSONArray array = new JSONArray();

		for (Review review : reviews) {
			JSONObject obj = new JSONObject();

			obj.put("reviewNo", review.getReviewNo());
			obj.put("ctmNo", review.getCtmNo());
			obj.put("productCode", review.getProductCode());
			obj.put("reviewGrade", review.getReviewGrade());
			obj.put("reviewTitle", review.getReviewTitle());
			obj.put("reviewContents", review.getReviewContents());
			obj.put("reviewDate", review.getReviewDate());
			obj.put("ctmId", review.getCtmId());
			obj.put("productName", review.getProductName());

			array.add(obj);
		}

		totalObj.put("reviews", array);
		totalObj.put("pageBuilder", pageBuilder);
		String string = totalObj.toJSONString();
		
		System.out.println(string);
		
		response.getWriter().println(totalObj);

		pageBuilder.build();
		
		return null;

	}
}