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
	public Customer read(String ctm_id) {
		return customerDao.read(ctm_id);
	}
	
	/** 회원 여부 반환 */
	@Override
	public Customer isMember(String ctm_id, String ctm_passwd) {
		return customerDao.isMember(ctm_id, ctm_passwd);
	}
	
	/** 회원 탈퇴 - 비밀번호 확인 */
	@Override
	public boolean deleteConfirm(String ctm_id, String ctm_passwd) {
		return customerDao.deleteConfirm(ctm_id, ctm_passwd);
	}
	
	/** 회원삭제 */
	@Override
	public void deleteCustomer(String ctm_id) {
		customerDao.deleteCustomer(ctm_id);
	}
	
	/** ID 중복 체크 */
	@Override
	public boolean checkId(String ctm_id) {
		return customerDao.checkId(ctm_id);
	}

	
	public static void main(String[] args) {
		CustomerService service = new CustomerServiceImpl();
		List<Customer> list = service.listAll();
		System.out.println(list);
	}
}







