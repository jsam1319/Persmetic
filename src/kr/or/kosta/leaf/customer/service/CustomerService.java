package kr.or.kosta.leaf.customer.service;

import java.util.List;

import kr.or.kosta.leaf.customer.domain.Customer;

/**
 * Domain(업무영역)별 고객의 요구사항을 반영하는 비즈니스 메소드 선언
 * 
 * @author 손정화
 *
 */
public interface CustomerService {

	/** 신규 회원 등록 */
	public void create(Customer Customer);

	/** 전체 회원목록 반환 */
	public List<Customer> listAll();
	
	/** 사용자아이디를 이용한 사용자 상세 정보 조회 */
	public Customer read(String ctmId);
	
	/** 회원 여부 반환 */
	public Customer isMember(String ctmId, String ctmPasswd);
	
	/** 회원 탈퇴 - 비밀번호 확인 */
	public boolean deleteConfirm(String ctmId, String ctmPasswd);
	
	/** 회원삭제 */
	public void deleteCustomer(String ctmId);	
	
	/** ID 중복 체크 */
	public boolean checkId(String ctmId);
	
}
