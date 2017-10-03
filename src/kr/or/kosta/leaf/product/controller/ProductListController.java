package kr.or.kosta.leaf.product.controller;

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
import kr.or.kosta.leaf.common.web.Params;
import kr.or.kosta.leaf.product.domain.Product;
import kr.or.kosta.leaf.product.service.ProductService;
import kr.or.kosta.leaf.product.service.ProductServiceImpl;

public class ProductListController implements Controller {

	ModelAndView mav = new ModelAndView();
	ProductService service = new ProductServiceImpl();
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int page = Integer.parseInt(request.getParameter("page"));
		
		Params params = new Params(page, null, null, 10, 5);
		
		List<Product> products = service.ListByParams(params);
		
		mav.addObject("list", products);
		mav.setView("category.leaf");
		
		return mav;
	}
}
