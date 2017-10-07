package kr.or.kosta.leaf.stats.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import kr.or.kosta.leaf.common.controller.Controller;
import kr.or.kosta.leaf.common.controller.ModelAndView;
import kr.or.kosta.leaf.stats.domain.Stats;
import kr.or.kosta.leaf.stats.service.StatsService;
import kr.or.kosta.leaf.stats.util.StatsUtil;

public class StatsController implements Controller {
	
	StatsService service = new StatsService();

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter writer = response.getWriter();
		response.setCharacterEncoding("UTF-8");
		
		JSONObject json = null;
		
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String callback = request.getParameter("callback");
		System.out.println(callback);
		
		System.out.println(startDate + " ~ " + endDate);
		
		List<Stats> statses = service.getStatses(startDate, endDate);
		Map<String, List<Stats>> map = new HashMap<String, List<Stats>>();

		for (Stats stats : statses) {
			if(!map.containsKey(stats.getOrderDate())) {
				ArrayList list = new ArrayList<Stats>();
				list.add(stats);
				
				map.put(stats.getOrderDate(), list);
			}
			
			else {
				ArrayList list = (ArrayList) map.get(stats.getOrderDate());
				list.add(stats);
				
				map.remove(stats.getOrderDate());
				
				map.put(stats.getOrderDate(), list);
			}
		}
		
		json = StatsUtil.mapToJson(map);
		
		System.out.println(json.toJSONString());

		writer.print(json);
		writer.flush();
		writer.close();
		
		/*mav.addObject("json", json);
		mav.setView("statsJson.leaf");
		*/
		return null;
	}
}
