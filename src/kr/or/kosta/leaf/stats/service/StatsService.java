package kr.or.kosta.leaf.stats.service;

import java.util.List;

import kr.or.kosta.leaf.common.db.DaoFactory;
import kr.or.kosta.leaf.order_item.dao.JdbcOrderItemDao;
import kr.or.kosta.leaf.order_item.dao.OrderItemDao;
import kr.or.kosta.leaf.order_item.domain.OrderItem;
import kr.or.kosta.leaf.product.dao.JdbcProductDao;
import kr.or.kosta.leaf.product.dao.ProductDao;
import kr.or.kosta.leaf.stats.dao.JdbcStatsDao;
import kr.or.kosta.leaf.stats.dao.StatsDao;
import kr.or.kosta.leaf.stats.domain.Stats;
import kr.or.kosta.leaf.total_order.dao.JdbcTotalOrderDao;
import kr.or.kosta.leaf.total_order.dao.TotalOrderDao;

public class StatsService {
	
	
	TotalOrderDao totalOrderDao = (TotalOrderDao)DaoFactory.getInstance().getDao(JdbcTotalOrderDao.class);
	OrderItemDao orderItemDao = (OrderItemDao)DaoFactory.getInstance().getDao(JdbcOrderItemDao.class);
	ProductDao productDao = (ProductDao)DaoFactory.getInstance().getDao(JdbcProductDao.class);
	StatsDao statsDao = (StatsDao)DaoFactory.getInstance().getDao(JdbcStatsDao.class);
	
	
	/* 날짜 별 주문 조회 */
	public List<Stats> getStatses(String startDate, String endDate) {
		return statsDao.getStatses(startDate, endDate);
	}
	
	public List<OrderItem> orderItemRead(int orderNo) {
		return orderItemDao.read(orderNo);
	}
	
	public String getProductName(int productCode) {
		return productDao.read(productCode).getProductName();
	}
}
