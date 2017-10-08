package kr.or.kosta.leaf.customer.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosta.leaf.common.controller.Controller;
import kr.or.kosta.leaf.common.controller.ModelAndView;
import kr.or.kosta.leaf.customer.domain.Customer;
import kr.or.kosta.leaf.customer.service.CustomerService;
import kr.or.kosta.leaf.customer.service.CustomerServiceImpl;

/**
 * 
 * 회원가입처리
 * 
 * @author 박보라
 *
 */
public class CustomerJoinController implements Controller {

	private CustomerService customerService = new CustomerServiceImpl();

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
  
		ModelAndView mav = new ModelAndView();

		request.setCharacterEncoding("UTF-8");

		String ctmName = request.getParameter("ctm_name");
		String ctmId = request.getParameter("ctm_id");
		String ctmPasswd = request.getParameter("ctm_passwd");
		int ctmAge = Integer.parseInt(request.getParameter("ctm_age"));
		String ctmGender = request.getParameter("ctm_gender");
		String ctmAddress = request.getParameter("ctm_address");
		String ctmJob = request.getParameter("ctm_job");
		String ctmEmail = request.getParameter("ctm_email");

		
		
		// JavaBean 생성
		Customer customer = new Customer();
		customer.setCtmName(ctmName);
		customer.setCtmId(ctmId);
		customer.setCtmPasswd(ctmPasswd);
		customer.setCtmAge(ctmAge);
		customer.setCtmGender(ctmGender);
		customer.setCtmAddress(ctmAddress);
		customer.setCtmJob(ctmJob);
		customer.setCtmEmail(ctmEmail);
		customer.setCtmDivision("일반회원");

		customerService.create(customer);
		customerService.checkId(ctmId);
		mav.addObject("customer", customer);

		mav.setView("/register_result.leaf");

		return mav;
	}

}
