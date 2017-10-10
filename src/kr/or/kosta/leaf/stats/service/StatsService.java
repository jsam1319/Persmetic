package kr.or.kosta.leaf.stats.service;

import java.util.List;

import kr.or.kosta.leaf.order_item.domain.OrderItem;
import kr.or.kosta.leaf.stats.domain.Stats;

public interface StatsService {

	public List<Stats> getStatses(String startDate, String endDate);
	
	public List<OrderItem> orderItemRead(int orderNo);
	
	public String getProductName(int productCode);
}
