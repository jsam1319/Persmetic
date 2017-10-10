package kr.or.kosta.leaf.review.dao;

import java.util.List;

import kr.or.kosta.leaf.common.web.Params;
import kr.or.kosta.leaf.review.domain.Review;

/**
 * 리뷰 관리를 위한 Dao Interface
 *
 * @author 박연주
 *
 */

public interface ReviewDao {
	
	/** 리뷰등록 */
	public void create(Review review);
	
	/** 리뷰 내용보기  */
	public Review read(int reviewNo);
	
	/** 리뷰 삭제 */
	public void delete(int reviewno);
	
	/** 리뷰 수정 */
	public void update(Review review);
	
	/** 선택 페이지에 대한 리뷰목록 반환 */
	public List<Review> listByParams(Params params, int productCode);

	/** 출력페이지 계산을 위한 {검색유형, 검색값}에 대한 행의 수 반환 */
	public int pageCount(Params params, int productCode);
	
	public List<Review> listAll(int productCode);
}
