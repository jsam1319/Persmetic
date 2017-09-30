package kr.or.kosta.leaf.product.dao;

import java.util.List;

import kr.or.kosta.leaf.common.web.Params;
import kr.or.kosta.leaf.product.domain.Product;

/**
 * 상품 정보, 등록을 위한 Dao Interface
 *
 * ************************
 * 2017-09-30 - 이재현
 * 메소드 명 변경(search_product -> read)
 * 
 * ************************
 *
 *
 * @author 박연주
 *
 */
public interface ProductDao {
	
	/** 상품등록 */
	public void create(Product product);
	
	/** 상품 상세보기(번호로 정보 찾기) */
	public Product read(int productCode);
	
	/** 상품정보 삭제 */
	public void delete(int productcode);
	
	/** 상품정보 수정 */
	public void update(Product product);
	
	/** 조회수 세기 */
	public void hitCount(int productcode);
	
	/** {선택페이지, 검색유형, 검색값, 한페이지당 출력 행수}에 대한 상품목록 반환 */
	public List<Product> listByParams(Params params);
	
	/** 출력페이지 계산을 위한 {검색유형, 검색값}에 대한 행의 수 반환 */
	public int pageCount(Params params);

}
