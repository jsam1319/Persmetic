package kr.or.kosta.leaf.search.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosta.leaf.common.controller.Controller;
import kr.or.kosta.leaf.common.controller.ModelAndView;
import kr.or.kosta.leaf.keyword.service.KeywordService;
import kr.or.kosta.leaf.keyword.service.KeywordServiceImpl;
import kr.or.kosta.leaf.product.domain.Product;
import kr.or.kosta.leaf.search.service.SearchService;
import kr.or.kosta.leaf.search.service.SearchServiceImpl;

public class SearchController implements Controller {

	SearchService searchService = new SearchServiceImpl();
	KeywordService keywordServie = new KeywordServiceImpl();
	ModelAndView mav = new ModelAndView();
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String keyword = request.getParameter("keyword");
		String[] keywords = keyword.split(" ");
		
		for (String string : keywords) {
			keywordServie.plusHitCount(string);
		}
		
		List<Product> products = searchService.listByKeyword(keywords);
		
		mav.addObject("list", products);
		mav.setView("category.leaf");
		
		return mav;
	}

	
}
