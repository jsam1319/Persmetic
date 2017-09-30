package kr.or.kosta.leaf.cart.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosta.leaf.cart.domain.Cart;
import kr.or.kosta.leaf.cart.domain.ProductCart;
import kr.or.kosta.leaf.cart.service.CartService;
import kr.or.kosta.leaf.cart.service.CartServiceImpl;
import kr.or.kosta.leaf.common.controller.Controller;
import kr.or.kosta.leaf.common.controller.ModelAndView;
import kr.or.kosta.leaf.product.domain.Product;


/**
 * 
 * Cart의 항목을 지우기 위한 컨트롤러
 * cart_delete.jsp와 매칭
 * 
 * @author 이재현
 *
 */

public class CartDeleteController implements Controller {

	private CartService cartService = new CartServiceImpl();
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		/* url Request에 따른 변수 초기화 */
		int ctmNo = Integer.parseInt(request.getParameter("ctm_no"));  
		int productCode = Integer.parseInt(request.getParameter("product_code")); 
		
		cartService.delete(productCode, ctmNo);
		
		ModelAndView mav = new ModelAndView();
		
		response.setContentType("text/html;charset=utf-8"); 
		
		mav.setView("redirect:/cart.leaf?ctm_no=" + ctmNo);
		
		return mav;
	}

}
