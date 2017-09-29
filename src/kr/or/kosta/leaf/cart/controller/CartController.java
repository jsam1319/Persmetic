package kr.or.kosta.leaf.cart.controller;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosta.leaf.cart.domain.Cart;
import kr.or.kosta.leaf.cart.service.CartService;
import kr.or.kosta.leaf.cart.service.CartServiceImpl;
import kr.or.kosta.leaf.common.controller.Controller;
import kr.or.kosta.leaf.common.controller.ModelAndView;

/**
 * 장바구니 리스트 처리
 * 
 * /cart 요청에 대한 세부 컨트롤러
 * @author 손정화
 *
 */
public class CartController implements Controller {

	private CartService cartService = new CartServiceImpl();
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)	throws ServletException {
		int ctmNo = Integer.parseInt(request.getParameter("ctm_no"));  //url request
		List<Cart> carts = cartService.listAll(ctmNo);
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("list", carts);
		response.setContentType("text/html;charset=utf-8"); 
		mav.setView("/basket.leaf");
		
		return mav;
	}

}




