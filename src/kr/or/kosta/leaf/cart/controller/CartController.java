package kr.or.kosta.leaf.cart.controller;

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
 * 장바구니 리스트 처리
 * 
 * /cart 요청에 대한 세부 컨트롤러
 * 
 * *************************
 * 2017-09-30 이재현
 * 상품 번호에 따른 상품 명 가져오기 위해
 * request에 담는 domain 객체 재 구성
 * *************************
 * 
 * @author 손정화
 *
 */
public class CartController implements Controller {

	private CartService cartService = new CartServiceImpl();
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)	throws ServletException {
		int ctmNo = Integer.parseInt(request.getParameter("ctm_no"));  //url request
		List<Cart> carts = cartService.listAll(ctmNo);
		/* 상품 명을 포함한 확장 carts 객체 선언 */
		List<Cart> productCarts = new ArrayList<Cart>();
		
		for (Cart cart : carts) {
			Product product = cartService.getProduct(cart.getProductCode());
			
			productCarts.add(new ProductCart(cart, product.getProductName(), product.getProductImage()));
		}
		
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("list", productCarts);
		response.setContentType("text/html;charset=utf-8"); 
		mav.setView("/basket.leaf");
		
		return mav;
	}

}




