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

public class ProductDetailController implements Controller {

	ModelAndView mav = new ModelAndView();
	
	ProductService productService = new ProductServiceImpl();

	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int productCode = Integer.parseInt(request.getParameter("product_code"));
		
		Product product = productService.read(productCode);
		
		mav.addObject("product", product);
		mav.setView("/detail.leaf");
		
		return mav;
	}

	
	
}
