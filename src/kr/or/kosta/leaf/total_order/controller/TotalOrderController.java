package kr.or.kosta.leaf.total_order.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosta.leaf.common.controller.Controller;
import kr.or.kosta.leaf.common.controller.ModelAndView;

public class TotalOrderController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String orderAddress = request.getParameter("address");
		String orderRecipient = request.getParameter("recipient");
		String totalPrice = request.getParameter("price");
		
		int ctmNo = 0;
		for (Cookie cookie : request.getCookies()) {
			if(cookie.getName().equals("customer")) ctmNo = Integer.parseInt(cookie.getValue());
		}
		
		
		return null;
	}

	
}
