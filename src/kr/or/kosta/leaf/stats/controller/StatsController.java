package kr.or.kosta.leaf.stats.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosta.leaf.common.controller.Controller;
import kr.or.kosta.leaf.common.controller.ModelAndView;
import kr.or.kosta.leaf.order_item.domain.OrderItem;
import kr.or.kosta.leaf.stats.service.StatsService;
import kr.or.kosta.leaf.total_order.domain.TotalOrder;

public class StatsController implements Controller {
	
	StatsService service = new StatsService();

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out = new PrintWriter(response.getOutputStream());	
		
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		
		System.out.println(startDate + " ~ " + endDate);
		
		List<TotalOrder> totalOrders = service.TotalOrderRead(startDate, endDate);
		List<OrderItem> orderItems = new ArrayList<OrderItem>();
		
		for (TotalOrder totalOrder : totalOrders) {
			orderItems.addAll(service.orderItemRead(totalOrder.getOrderNo()));
		}

		out.println(orderItems.toString());
		
		return null;
	
	
	}
}
