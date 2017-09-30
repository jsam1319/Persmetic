package kr.or.kosta.leaf.common.web;


import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * 회원 인증 여부 서블릿 필터
 */
public class LoginCheckFilter implements Filter {
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		String customer = null;
		Cookie[] cookies = ((HttpServletRequest)request).getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equalsIgnoreCase("customer")) {
					customer = cookie.getValue();
					break;
				}
			}
		}
		
		if(customer != null){
			chain.doFilter(request, response);
		}else{
			String loginForm = "/index.leaf";
			
			String referer = ((HttpServletRequest)request).getRequestURI();
			String contextPath = ((HttpServletRequest)request).getContextPath();
			referer = referer.substring(contextPath.length());
			
		
			request.setAttribute("referer", referer);
			
			request.getRequestDispatcher(loginForm).forward(request, response);
		}
	}

	@Override
	public void destroy() {	}
	
}
