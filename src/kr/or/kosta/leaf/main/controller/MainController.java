package kr.or.kosta.leaf.main.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosta.leaf.common.controller.Controller;
import kr.or.kosta.leaf.common.controller.ModelAndView;

/**
 * FrontController에서 일관된(표준화된) 실행메소드 호출이 가능토록 커맨드 패턴 적용한 세부 컨트롤러
 * /hello 요청에 대한 컨트롤러
 * @author 김기정
 *
 */
public class MainController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)	throws ServletException {
		ModelAndView mav = new ModelAndView();
		//String message = xxxService.bizMethod();
		String title = "모델2 기반 쇼핑몰";
		
		mav.addObject("title", title);
		mav.setView("/index.jsp");
//		mav.setView("redirect:http://www.naver.com");
//		mav.setView("redirect:"+request.getContextPath()+"/demo/hello.jsp");
		return mav;
	}

}




