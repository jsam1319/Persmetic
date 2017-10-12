package kr.or.kosta.leaf.log.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosta.leaf.common.controller.Controller;
import kr.or.kosta.leaf.common.controller.ModelAndView;
import kr.or.kosta.leaf.log.domain.Log;
import kr.or.kosta.leaf.log.domain.LogType;
import kr.or.kosta.leaf.log.service.LogService;
import kr.or.kosta.leaf.log.service.LogServiceImpl;

public class LogController implements Controller {

	LogService logService = new LogServiceImpl();
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String logType = request.getParameter("type");
		String logContent = request.getParameter("content");
		int ctmNo = 0;
		
		for (Cookie cookie : request.getCookies()) {
			if(cookie.getName().equals("customer")) 
				ctmNo = Integer.parseInt(cookie.getValue());
		}
		
		Log log = new Log();
		
		log.setCtmNo(ctmNo);
		log.setLogType(LogType.valueOf(logType));
		log.setLogContent(logContent);
		
		logService.insertLog(log);
		
		return null;
	}

	
}
