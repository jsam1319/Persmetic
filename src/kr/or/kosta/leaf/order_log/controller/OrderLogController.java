package kr.or.kosta.leaf.order_log.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import kr.or.kosta.leaf.common.controller.Controller;
import kr.or.kosta.leaf.common.controller.ModelAndView;
import kr.or.kosta.leaf.order_log.domain.OrderLog;
import kr.or.kosta.leaf.order_log.service.OrderLogService;
import kr.or.kosta.leaf.order_log.service.OrderLogServiceImpl;
import kr.or.kosta.leaf.order_log.util.OrderLogUtil;

public class OrderLogController implements Controller {

	OrderLogService service = new OrderLogServiceImpl();
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter writer = response.getWriter();
		
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		
		List<OrderLog> orderLogs = service.listByDate(startDate, endDate);
		
		JSONObject json = OrderLogUtil.mapToJson(orderLogs);
		
		writer.println(json);
		writer.flush();
		writer.close();
		
		return null;
	}

	
}
