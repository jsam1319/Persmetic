package kr.or.kosta.leaf.order_item.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosta.leaf.order_item.domain.OrderItem;
import kr.or.kosta.leaf.order_item.service.OrderItemService;
import kr.or.kosta.leaf.order_item.service.OrderItemServiceImpl;
import kr.or.kosta.leaf.common.controller.Controller;
import kr.or.kosta.leaf.common.controller.ModelAndView;
import kr.or.kosta.leaf.keyword.domain.Keyword;

/**
 * 바로 주문 처리
 * 
 * /orderitem 요청에 대한 세부 컨트롤러
 * @author 손정화
 *
 */
public class OrderItemCreateController implements Controller {
	
	private OrderItemService itemService = new OrderItemServiceImpl();

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)	throws ServletException {
		ModelAndView mav = new ModelAndView();
		response.setContentType("text/html;charset=utf-8"); 
		
		//int orderNo = Integer.parseInt(request.getParameter("order_no"));
		
		int orderPrice = Integer.parseInt(request.getParameter("order_price"));
		int orderCount = Integer.parseInt(request.getParameter("order_count"));
		String[] code = Integer.toString(Integer.parseInt(request.getParameter("product_code"))).split(",");
		
		for(int i=0; i<code.length; i++) {
			System.out.println(code[i]);
		}
		
		//int productCode = Integer.parseInt();
		
		// JavaBean 생성
		OrderItem item = new OrderItem();
		//item.setOrderNo(orderNo);
		//item.setProductCode(productCode);
		item.setOrderPrice(orderPrice);
		item.setOrderCount(orderCount);
		
		itemService.create(item);
		
		
		mav.addObject("list", item);
		mav.setView("order-address.leaf");
		
		return mav;
	}

}




