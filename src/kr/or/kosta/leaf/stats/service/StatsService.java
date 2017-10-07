package kr.or.kosta.leaf.stats.service;

import java.util.List;

import kr.or.kosta.leaf.common.db.DaoFactory;
import kr.or.kosta.leaf.order_item.dao.JdbcOrderItemDao;
import kr.or.kosta.leaf.order_item.dao.OrderItemDao;
import kr.or.kosta.leaf.order_item.domain.OrderItem;
import kr.or.kosta.leaf.total_order.dao.JdbcTotalOrderDao;
import kr.or.kosta.leaf.total_order.dao.TotalOrderDao;
import kr.or.kosta.leaf.total_order.domain.TotalOrder;

public class StatsService {
	
	
	TotalOrderDao totalOrderDao = (TotalOrderDao)DaoFactory.getInstance().getDao(JdbcTotalOrderDao.class);
	OrderItemDao orderItemDao = (OrderItemDao)DaoFactory.getInstance().getDao(JdbcOrderItemDao.class);
	
	/* 날짜 별 주문 조회 */
	public List<TotalOrder> TotalOrderRead(String startDate, String endDate) {
		return totalOrderDao.read(startDate, endDate);
	}
	
	public List<OrderItem> orderItemRead(int orderNo) {
		return orderItemDao.read(orderNo);
	}
}
