package kr.or.kosta.leaf.search.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import kr.or.kosta.leaf.common.controller.Controller;
import kr.or.kosta.leaf.common.controller.ModelAndView;
import kr.or.kosta.leaf.keyword.service.KeywordService;
import kr.or.kosta.leaf.keyword.service.KeywordServiceImpl;

public class AutoCompleteController implements Controller {

	KeywordService keywordService = new KeywordServiceImpl();
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter writer = response.getWriter();
		
		String keywordName = request.getParameter("keyword");
		List<String> keywordNames = keywordService.getKeywordNames(keywordName);

		String keywordCsv = "";
		
		for (String string : keywordNames) {
			if(keywordCsv.length() < 1) keywordCsv = keywordCsv + string;
			else									 keywordCsv = keywordCsv + "," + string;
		}
		
		writer.println(keywordCsv);
		writer.flush();
		writer.close();
		
		return null;
	}

	
}
