package kr.or.kosta.leaf.order_log.util;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import kr.or.kosta.leaf.order_log.domain.OrderLog;

public class OrderLogUtil {
	
	public static JSONObject mapToJson(List<OrderLog> orderLogs) {
		JSONObject json = new JSONObject();
		JSONArray jsonArray = new JSONArray();
		
		json.put("size", orderLogs.size());
		
		for (OrderLog orderLog : orderLogs) {
			JSONObject orderJson = new JSONObject();
			
			orderJson.put("productCode", orderLog.getProductCode());
			orderJson.put("productName", orderLog.getProductName());
			orderJson.put("orderPrice", orderLog.getOrderPrice());
			orderJson.put("orderCount", orderLog.getOrderCount());
			orderJson.put("orderDate", orderLog.getOrderDate());
			orderJson.put("ctmName", orderLog.getCtmName());
			orderJson.put("orderYN", orderLog.getOrderYN());
			
			jsonArray.add(orderJson);
		}

		json.put("orderLogs", jsonArray);
		
		return json;
	}
}
