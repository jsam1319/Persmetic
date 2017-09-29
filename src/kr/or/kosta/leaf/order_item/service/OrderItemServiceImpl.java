package kr.or.kosta.leaf.order_item.service;

import java.util.List;

import kr.or.kosta.leaf.common.db.DaoFactory;
import kr.or.kosta.leaf.order_item.dao.JdbcOrderItemDao;
import kr.or.kosta.leaf.order_item.dao.OrderItemDao;
import kr.or.kosta.leaf.order_item.domain.OrderItem;

public class OrderItemServiceImpl implements OrderItemService {
	
	OrderItemDao itemDao = (OrderItemDao)DaoFactory.getInstance().getDao(JdbcOrderItemDao.class);
	
	@Override
	public List<OrderItem> listAll(int orderNo) {
		return itemDao.listAll(orderNo);
	}
	
	@Override
	public void create(OrderItem orderItem) {
		itemDao.create(orderItem);
	}

	@Override
	public OrderItem read(int orderNo, int productCode) {
		return itemDao.read(orderNo, productCode);
	}
	
	@Override
	public void delete(int orderNo, int productCode) {
		itemDao.delete(orderNo, productCode);
	}
	
	public static void main(String[] args) {
		OrderItemService service = new OrderItemServiceImpl();
		List<OrderItem> list = service.listAll(2);	
		System.out.println(list);
	}
}







