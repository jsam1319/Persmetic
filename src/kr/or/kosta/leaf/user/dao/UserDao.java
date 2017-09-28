package kr.or.kosta.leaf.user.dao;

import java.util.List;

import kr.or.kosta.leaf.user.domain.User;

public interface UserDao {

	/** 신규 회원 등록 */
	public void create(User user);

	/** 전체 회원목록 반환 */
	public List<User> listAll();
	
	/** 사용자아이디를 이용한 사용자 상세 정보 조회 */
	public User read(String ctm_id);
	
	/** 회원 여부 반환 */
	public User isMember(String ctm_id, String ctm_passwd);
	
	/** 회원 탈퇴 - 비밀번호 확인 */
	public boolean deleteConfirm(String ctm_id, String ctm_passwd);
	
	/** 회원삭제 */
	public void deleteUser(String ctm_id);	
	
	/** ID 중복 체크 */
	   public boolean checkId(String ctm_id);

}
