package kr.or.kosta.leaf.order_item.controller;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosta.leaf.common.controller.Controller;
import kr.or.kosta.leaf.common.controller.ModelAndView;
import kr.or.kosta.leaf.order_item.domain.OrderItem;
import kr.or.kosta.leaf.order_item.service.OrderItemService;
import kr.or.kosta.leaf.order_item.service.OrderItemServiceImpl;

/**
 * 주문항목 리스트 처리
 * 
 * /orderitem 요청에 대한 세부 컨트롤러
 * @author 손정화
 *
 */
public class OrderItemController implements Controller {

	private OrderItemService itemService = new OrderItemServiceImpl();
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)	throws ServletException {
		int orderNo = Integer.parseInt(request.getParameter("order_no"));  //url request
		List<OrderItem> items = itemService.listAll(orderNo);
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("list", items);
		response.setContentType("text/html;charset=utf-8"); 
		mav.setView("/order-address.leaf");
		
		return mav;
	}
}




