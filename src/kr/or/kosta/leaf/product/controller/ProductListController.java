package kr.or.kosta.leaf.product.controller;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosta.leaf.common.controller.Controller;
import kr.or.kosta.leaf.common.controller.ModelAndView;
import kr.or.kosta.leaf.common.web.PageBuilder;
import kr.or.kosta.leaf.common.web.Params;
import kr.or.kosta.leaf.product.domain.Product;
import kr.or.kosta.leaf.product.service.ProductService;
import kr.or.kosta.leaf.product.service.ProductServiceImpl;

public class ProductListController implements Controller {

	ModelAndView mav = new ModelAndView();
	ProductService service = new ProductServiceImpl();
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String pageNo = request.getParameter("page");
			if(pageNo==null) pageNo="1";
		int page = Integer.parseInt(pageNo);

		//	private String type;      /** 사용자 검색 유형 */
		//	private String value;     /** 사용자 검색 값 */
		
		Params params = new Params(page, null, null, 12, 5);
		
		List<Product> products = service.ListByParams(params);
		
		int totalRowCount = service.pageCount(params);
		PageBuilder pageBuilder = new PageBuilder(params, totalRowCount);
		pageBuilder.build();
		
		mav.addObject("list", products);
		mav.addObject("pageBuilder", pageBuilder);
		mav.setView("category.leaf");
		
		return mav;
	}
}