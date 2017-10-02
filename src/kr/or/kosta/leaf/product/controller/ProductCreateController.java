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

public class ProductCreateController implements Controller {

	ProductService productService = new ProductServiceImpl();
	ModelAndView mav = new ModelAndView();
	String location = "/index.leaf";
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Product product = new Product();
		
		product.setProductName(request.getParameter("name"));
		product.setProductPrice(Integer.parseInt(request.getParameter("price")));
		product.setProductBrand(request.getParameter("brand"));
		product.setProductColor(request.getParameter("color"));
		product.setProductTone(request.getParameter("tone"));
		product.setProductExplain(request.getParameter("contents"));
		product.setProductImage(request.getParameter("front"));
		product.setProductSow(Integer.parseInt(request.getParameter("sow")));
		
		
		productService.create(product);
		
		
		mav.setView(location);
		
		return mav;
	}

}
