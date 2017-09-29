package kr.or.kosta.leaf.total_order.service;

import java.util.List;

import kr.or.kosta.leaf.common.db.DaoFactory;
import kr.or.kosta.leaf.total_order.dao.JdbcTotalOrderDao;
import kr.or.kosta.leaf.total_order.dao.TotalOrderDao;
import kr.or.kosta.leaf.total_order.domain.TotalOrder;

public class TotalOrderServiceImpl implements TotalOrderService {
	
	TotalOrderDao orderDao = (TotalOrderDao)DaoFactory.getInstance().getDao(JdbcTotalOrderDao.class);
	
	@Override
	public List<TotalOrder> listAll() {
		return orderDao.listAll();
	}
	
	@Override
	public void create(TotalOrder totalOrder) {
		orderDao.create(totalOrder);
	}

	@Override
	public TotalOrder read(int orderNo) {
		return orderDao.read(orderNo);
	}
	
	@Override
	public void delete(int orderNo) {
		orderDao.delete(orderNo);
	}
	
	public static void main(String[] args) {
		TotalOrderService service = new TotalOrderServiceImpl();
		List<TotalOrder> list = service.listAll();	
		System.out.println(list);
	}
}







