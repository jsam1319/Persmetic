package kr.or.kosta.leaf.order_item.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosta.leaf.common.controller.Controller;
import kr.or.kosta.leaf.common.controller.ModelAndView;
import kr.or.kosta.leaf.customer.service.CustomerService;
import kr.or.kosta.leaf.customer.service.CustomerServiceImpl;
import kr.or.kosta.leaf.order_item.domain.OrderItem;
import kr.or.kosta.leaf.order_item.domain.ProductOrderItem;
import kr.or.kosta.leaf.order_item.service.OrderItemService;
import kr.or.kosta.leaf.order_item.service.OrderItemServiceImpl;
import kr.or.kosta.leaf.product.service.ProductService;
import kr.or.kosta.leaf.product.service.ProductServiceImpl;

/**
 * 바로 주문 처리
 * 
 * /orderitem 요청에 대한 세부 컨트롤러
 * @author 손정화
 *
 */
public class OrderItemCreateController implements Controller {
	
	private OrderItemService itemService = new OrderItemServiceImpl();
	private ProductService productService = new ProductServiceImpl();
	private CustomerService customerService = new CustomerServiceImpl();
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)	throws ServletException {
		ModelAndView mav = new ModelAndView();
		response.setContentType("text/html;charset=utf-8"); 
		
		//int orderNo = Integer.parseInt(request.getParameter("order_no"));
		
		String[] quantitiys = request.getParameter("quantity").split(",");
		String[] codes = request.getParameter("product_code").split(",");
		
			
		List<OrderItem> items = new ArrayList<OrderItem>();
		
		for(int i=0; i<codes.length; i++) {
			ProductOrderItem item = new ProductOrderItem();
			item.setProductCode(Integer.parseInt(codes[i]));
			item.setOrderCount(Integer.parseInt(quantitiys[i]));
			item.setProductImage(productService.read(Integer.parseInt(codes[i])).getProductImage());
			item.setProductName(productService.read(Integer.parseInt(codes[i])).getProductName());
			item.setProductPrice(productService.read(Integer.parseInt(codes[i])).getProductPrice());
			item.setOrderPrice(item.getOrderCount() * item.getProductPrice());
			
			items.add(item);
			System.out.println("item : " + item);
		}
		int ctmNo = 0;
		
		for (Cookie cookie : request.getCookies()) {
			if(cookie.getName().equals("customer"))
				ctmNo = Integer.parseInt(cookie.getValue());
		}
		
		mav.addObject("list", items);
		mav.addObject("user", customerService.read(ctmNo));
		mav.setView("order-address.leaf");
		
		return mav;
	}

}




