package kr.or.kosta.leaf.order_log.dao;

import java.util.List;

import kr.or.kosta.leaf.order_log.domain.OrderLog;

public interface OrderLogDao {

	public List<OrderLog> listByDate(String startDate, String endDate);
}
