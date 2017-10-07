package kr.or.kosta.leaf.stats.util;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import kr.or.kosta.leaf.stats.domain.Stats;

public class StatsUtil {

	public static JSONObject mapToJson(Map<String, List<Stats>> map) {
		JSONObject json = new JSONObject();
		
		Set<String> keySet = map.keySet();
		
		for (String key : keySet) {
			JSONArray jsonArray = new JSONArray();
			List<Stats> statses = map.get(key);
			
			for (Stats stats : statses) {
				JSONObject subJson = new JSONObject();
				
				subJson.put("name", stats.getProductName());
				subJson.put("count" , stats.getOrderCount());
				
				jsonArray.add(subJson);
			}

			json.put(key, jsonArray);
		}
		
		
		return json;
	}
}
