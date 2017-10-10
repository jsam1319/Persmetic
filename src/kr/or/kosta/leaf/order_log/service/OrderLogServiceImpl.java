package kr.or.kosta.leaf.order_log.service;

import java.util.List;

import kr.or.kosta.leaf.common.db.DaoFactory;
import kr.or.kosta.leaf.order_log.dao.JdbcOrderLogDao;
import kr.or.kosta.leaf.order_log.dao.OrderLogDao;
import kr.or.kosta.leaf.order_log.domain.OrderLog;

public class OrderLogServiceImpl implements OrderLogService {

	OrderLogDao orderLogDao = (OrderLogDao)DaoFactory.getInstance().getDao(JdbcOrderLogDao.class);
	
	@Override
	public List<OrderLog> listByDate(String startDate, String endDate) {
		// TODO Auto-generated method stub
		return orderLogDao.listByDate(startDate, endDate);
	}

	
}
