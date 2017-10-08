package kr.or.kosta.leaf.cart.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosta.leaf.cart.domain.Cart;
import kr.or.kosta.leaf.cart.service.CartService;
import kr.or.kosta.leaf.cart.service.CartServiceImpl;
import kr.or.kosta.leaf.common.controller.Controller;
import kr.or.kosta.leaf.common.controller.ModelAndView;


/**
 * 
 * Cart의 항목을 추가하기 위한 컨트롤러
 * 
 * @author 손정화
 *
 */

public class CartCreateController implements Controller {

	private CartService cartService = new CartServiceImpl();
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ModelAndView mav = new ModelAndView();
		
		response.setContentType("text/html;charset=utf-8"); 
		
		/* url Request에 따른 변수 초기화 */
		int productCode = Integer.parseInt(request.getParameter("product_code")); 
		int ctmNo = Integer.parseInt(request.getParameter("ctm_no"));  
		int cartQuantity = Integer.parseInt(request.getParameter("cart_quantity"));
		int cartPrice = Integer.parseInt(request.getParameter("cart_price"));
		
		Cart cart = new Cart();
		cart.setProductCode(productCode);
		cart.setCtmNo(ctmNo);
		cart.setCartQuantity(cartQuantity);
		cart.setCartPrice(cartPrice);
		
		cartService.create(cart);
		
		mav.setView("/cart.leaf?ctm_no=" + ctmNo);
		
		return mav;
	}

}
