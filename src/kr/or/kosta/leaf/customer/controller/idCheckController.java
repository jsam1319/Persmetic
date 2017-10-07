package kr.or.kosta.leaf.customer.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosta.leaf.common.controller.Controller;
import kr.or.kosta.leaf.common.controller.ModelAndView;
import kr.or.kosta.leaf.customer.service.CustomerService;
import kr.or.kosta.leaf.customer.service.CustomerServiceImpl;

public class idCheckController implements Controller {
	
	CustomerService customerService = new CustomerServiceImpl();
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter writer = response.getWriter();

		
		String ctmId = request.getParameter("ctm_id");
		
		if(customerService.checkId(ctmId)) {

			writer.println("사용중인 아이디 입니다.");
			
		}else {
			writer.println("사용가능한 아이디입니다.");
		}
		

		writer.flush();
		writer.close();
		
		return null;
	}

}
