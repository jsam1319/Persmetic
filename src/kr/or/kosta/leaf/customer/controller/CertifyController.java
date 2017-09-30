package kr.or.kosta.leaf.customer.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosta.leaf.common.controller.Controller;
import kr.or.kosta.leaf.common.controller.ModelAndView;
import kr.or.kosta.leaf.customer.domain.Customer;
import kr.or.kosta.leaf.customer.service.CustomerService;
import kr.or.kosta.leaf.customer.service.CustomerServiceImpl;


public class CertifyController implements Controller {

	CustomerService customerService = new CustomerServiceImpl();

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ModelAndView mav = new ModelAndView();
		String location = "/index.leaf";
		
		// 로그인
		if(request.getMethod().equalsIgnoreCase("post")) {
			String ctmId = request.getParameter("ctm_id");
			String ctmPasswd = request.getParameter("ctm_passwd");
			String referer = request.getParameter("referer");

			Customer customer = customerService.isMember(ctmId, ctmPasswd);
			if(customer != null){
			    String ctmInfo = null;
				try {
					ctmInfo = URLEncoder.encode(customer.getCtm_id() + "," + customer.getCtm_name(), "utf-8");
				} catch (UnsupportedEncodingException e) {
					throw new ServletException("CustomerAuthController.handleRequest() 실행중 예외 발생", e);
				}
				Cookie loginCookie = new Cookie("customer", ctmInfo);
				loginCookie.setPath("/");
				response.addCookie(loginCookie);
			    if(referer != null)  location = referer;
			    System.out.println("아이디 :" + ctmId);
			    System.out.println("비번 :" + ctmPasswd);
			    
			}else{
			  location = "/login.leaf";
			}
		}else {// 로그아웃
			String customer = null;
			Cookie[] cookies = request.getCookies();
			if (cookies != null) {
				for (Cookie cookie : cookies) {
					if (cookie.getName().equalsIgnoreCase("customer")) {
						cookie.setMaxAge(0);
						cookie.setPath("/");
						response.addCookie(cookie);
						break;
					}
				}
			}
		}
		mav.setView("redirect:"+request.getContextPath() + location);
		return mav;
	}
		
	}
	
	
	


