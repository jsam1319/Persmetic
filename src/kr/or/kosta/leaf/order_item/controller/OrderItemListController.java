package kr.or.kosta.leaf.order_item.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import kr.or.kosta.leaf.common.controller.Controller;
import kr.or.kosta.leaf.common.controller.ModelAndView;
import kr.or.kosta.leaf.order_item.domain.OrderItem;
import kr.or.kosta.leaf.order_item.service.OrderItemService;
import kr.or.kosta.leaf.order_item.service.OrderItemServiceImpl;

/**
 * 주문리스트 처리
 * 
 * /orderitem 요청에 대한 세부 컨트롤러
 * @author 손정화
 *
 */
public class OrderItemListController implements Controller {
	
	private OrderItemService itemService = new OrderItemServiceImpl();
	ModelAndView mav = new ModelAndView();
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		
//		response.setCharacterEncoding("utf-8");
//		response.setContentType("application/json");
		
//		JSONObject totalObj = new JSONObject();
//		JSONArray array = new JSONArray();
//		
//		for (OrderItem orderitem : item) {
//			JSONObject obj = new JSONObject();
//			
//			obj.put("orderNo", orderitem.getOrderNo());
//			obj.put("productCode", orderitem.getProductCode());
//			obj.put("orderPrice", orderitem.getOrderPrice());
//			obj.put("orderCount", orderitem.getOrderCount());
//			
//			array.add(obj);
//		}
//		
//		totalObj.put("item", array);
//		String string = totalObj.toJSONString();
//		
//		System.out.println(string);
//		
//		response.getWriter().println(totalObj);
		
		int orderNo = Integer.parseInt(request.getParameter("order_no"));
		List<OrderItem> item = itemService.listAll(orderNo);
		
		mav.addObject("list", item);
		mav.setView("order-address.leaf");
		
		return mav;
	}

}




