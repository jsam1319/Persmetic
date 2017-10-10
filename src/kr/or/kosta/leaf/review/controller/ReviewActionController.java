package kr.or.kosta.leaf.review.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosta.leaf.common.controller.Controller;
import kr.or.kosta.leaf.common.controller.ModelAndView;
import kr.or.kosta.leaf.customer.domain.Customer;
import kr.or.kosta.leaf.customer.service.CustomerService;
import kr.or.kosta.leaf.customer.service.CustomerServiceImpl;
import kr.or.kosta.leaf.product.domain.Product;
import kr.or.kosta.leaf.product.service.ProductService;
import kr.or.kosta.leaf.product.service.ProductServiceImpl;

public class ReviewActionController implements Controller{
	
	ProductService productService = new ProductServiceImpl();
	CustomerService customerService = new CustomerServiceImpl();
	ModelAndView mav = new ModelAndView();
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int productCode = Integer.parseInt(request.getParameter("productCode"));
		int ctmNo = Integer.parseInt(request.getParameter("ctmNo"));
		
		Product product = productService.read(productCode);
		Customer customer = customerService.read(ctmNo);
		
		mav.addObject("product", product);
		mav.addObject("customer", customer);
		mav.setView("review.leaf");
		
		return mav;

}
}