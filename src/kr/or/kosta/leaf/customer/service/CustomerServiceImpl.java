package kr.or.kosta.leaf.customer.service;

import java.util.List;

import kr.or.kosta.leaf.common.db.DaoFactory;
import kr.or.kosta.leaf.customer.dao.CustomerDao;
import kr.or.kosta.leaf.customer.dao.JdbcCustomerDao;
import kr.or.kosta.leaf.customer.domain.Customer;

public class CustomerServiceImpl implements CustomerService {
	
	CustomerDao customerDao = (CustomerDao)DaoFactory.getInstance().getDao(JdbcCustomerDao.class);

	/** 신규 회원 등록 */
	@Override
	public void create(Customer customer) {
		customerDao.create(customer);
	}

	/** 전체 회원목록 반환 */
	@Override
	public List<Customer> listAll(){
		return customerDao.listAll();
	}
	
	/** 사용자아이디를 이용한 사용자 상세 정보 조회 */
	@Override
	public Customer read(String ctmId) {
		return customerDao.read(ctmId);
	}
	
	/** 회원 여부 반환 */
	@Override
	public Customer isMember(String ctmId, String ctmPasswd) {
		return customerDao.isMember(ctmId, ctmPasswd);
	}
	
	/** 회원 탈퇴 - 비밀번호 확인 */
	@Override
	public boolean deleteConfirm(String ctmId, String ctmPasswd) {
		return customerDao.deleteConfirm(ctmId, ctmPasswd);
	}
	
	/** 회원삭제 */
	@Override
	public void deleteCustomer(String ctmId) {
		customerDao.deleteCustomer(ctmId);
	}
	
	/** ID 중복 체크 */
	@Override
	public boolean checkId(String ctmId) {
		return customerDao.checkId(ctmId);
	}

	
	public static void main(String[] args) {
		CustomerService service = new CustomerServiceImpl();
		List<Customer> list = service.listAll();
		System.out.println(list);
	}
}







