package kr.or.kosta.leaf.order_log.service;

import java.util.List;

import kr.or.kosta.leaf.order_log.domain.OrderLog;

public interface OrderLogService {

	public List<OrderLog> listByDate(String startDate, String endDate);
}
