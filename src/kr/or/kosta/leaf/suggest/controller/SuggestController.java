package kr.or.kosta.leaf.suggest.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import kr.or.kosta.leaf.common.controller.Controller;
import kr.or.kosta.leaf.common.controller.ModelAndView;
import kr.or.kosta.leaf.customer.service.CustomerService;
import kr.or.kosta.leaf.customer.service.CustomerServiceImpl;
import kr.or.kosta.leaf.product.domain.Product;
import kr.or.kosta.leaf.product.service.ProductService;
import kr.or.kosta.leaf.product.service.ProductServiceImpl;
import kr.or.kosta.leaf.suggest.util.SimilarityUtil;

public class SuggestController implements Controller {

	ProductService productService = new ProductServiceImpl();
	CustomerService customerService = new CustomerServiceImpl();
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter writer = response.getWriter();

		int ctmNo = Integer.parseInt(request.getParameter("ctm_no"));
		
		SimilarityUtil util = new SimilarityUtil(ctmNo);
		int index[] = util.getSuggest(productService.read(util.getMostItem(ctmNo)));
		System.out.println("INDEX : " + Arrays.toString(index));
		List<Product> products = new ArrayList<Product>();
		for(int i=0; i<index.length; i++) {
			products.add(productService.read(index[i]));
		}
		
		JSONObject json = new JSONObject();
		JSONArray array = new JSONArray();
		
		for(int i=0; i<products.size(); i++) {
			JSONObject subJson = new JSONObject();
			
			subJson.put("productCode", products.get(i).getProductCode());
			subJson.put("productName", products.get(i).getProductName());
			subJson.put("productImage", products.get(i).getProductImage());
			subJson.put("productPrice", products.get(i).getProductPrice());
		
			array.add(subJson);
		}
		
		json.put("products", array);
		
		writer.println(json);
		writer.flush();
		writer.close();
		
		return null;
	}

}
