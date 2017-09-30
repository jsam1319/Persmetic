package kr.or.kosta.leaf.review.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import kr.or.kosta.leaf.common.db.DaoFactory;
import kr.or.kosta.leaf.common.web.Params;
import kr.or.kosta.leaf.review.domain.Review;

/**
 * 리뷰 테이블 관련 DAO 클래스
 * 
 * @author 박연주
 *
 */

public class JdbcReviewDao implements ReviewDao {
	private DataSource dataSource;

	public JdbcReviewDao() {
	}

	public JdbcReviewDao(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	
	/** 리뷰등록 */
	public void create(Review review) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		String sql = " INSERT INTO REVIEW(REVIEW_NO,\r\n" + 
				"         				   CTM_NO,\r\n" + 
				"         				   PRODUCT_CODE,\r\n" + 
				"          			 	   REVIEW_GRADE,\r\n" + 
				"         		 	       REVIEW_TITLE,\r\n" + 
				"          		 	       REVIEW_CONTENTS)" +
				" VALUES ((SELECT max(REVIEW_NO) from REVIEW)+1, ?, ?, ?, ?, ?)";

		try {
			con = dataSource.getConnection();
			con.setAutoCommit(false);

			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, review.getCtmNo());
			pstmt.setInt(2, review.getProductCode());
			pstmt.setInt(3, review.getReviewGrade());
			pstmt.setString(4, review.getReviewTitle());
			pstmt.setString(5, review.getReviewContents());
			
			pstmt.executeUpdate();

			System.out.println("create 완료!");
			con.commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	/** 리뷰 삭제 */
	public void delete(int reviewno) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = " DELETE FROM REVIEW WHERE REVIEW_NO=?";
		
		try {
			con = dataSource.getConnection();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, reviewno);
			pstmt.executeUpdate();

			System.out.println("delete 완료!");
			con.commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}


	
	/** 리뷰 수정 */
	public void update(Review review) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = " UPDATE REVIEW "
				+ "SET REVIEW_GRADE=?, REVIEW_TITLE=?, REVIEW_CONTENTS=? "
				+ "WHERE REVIEW_NO=?";
		try {
			con = dataSource.getConnection();
			con.setAutoCommit(false);
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, review.getReviewGrade());
			pstmt.setString(2, review.getReviewTitle());
			pstmt.setString(3, review.getReviewContents());
			pstmt.setInt(4, review.getReviewNo());
			
			System.out.println("update 완료!");
			con.commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	private Review createReview(ResultSet rs) throws SQLException {
		int reviewNo = rs.getInt("reviewNo");
		int ctmNo = rs.getInt("ctmNo");
		int productCode = rs.getInt("productCode");
		int reviewGrade = rs.getInt("reviewGrade");
		String reviewTitle = rs.getString("reviewTitle");
		String reviewContents = rs.getString("reviewContents");
		String reviewDate = rs.getString("reviewDate");

		Review review = new Review();
		review.setReviewNo(reviewNo);
		review.setCtmNo(ctmNo);
		review.setProductCode(productCode);
		review.setReviewGrade(reviewGrade);
		review.setReviewTitle(reviewTitle);
		review.setReviewContents(reviewContents);
		review.setReviewDate(reviewDate);

		return review;
	}
	
	
	/** 선택 페이지에 대한 회원목록 반환 */
	public List<Review> listByPage(int page) {
		List<Review> list = null;	
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		ResultSet rs = null;
		
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT REVIEW_NO,");
		sb.append("        CTM_NO,");
		sb.append("        PRODUCT_CODE,");
		sb.append("        REVIEW_GRADE,");
		sb.append("        REVIEW_TITLE,");
		sb.append("        REVIEW_CONTENTS,");
		sb.append("        REVIEW_DATE");
		sb.append(" FROM   (SELECT CEIL(rownum / 5) request_page,");
		sb.append("                REVIEW_NO,");
		sb.append("                CTM_NO,");
		sb.append("                PRODUCT_CODE,");
		sb.append("                REVIEW_GRADE,");
		sb.append("                REVIEW_TITLE,");
		sb.append("                REVIEW_CONTENTS,");
		sb.append("                REVIEW_DATE");
		sb.append("         FROM   (SELECT REVIEW_NO,");
		sb.append("                        CTM_NO,");
		sb.append("                        PRODUCT_CODE,");
		sb.append("                        REVIEW_GRADE,");
		sb.append("                        REVIEW_TITLE,");
		sb.append("                        REVIEW_CONTENTS,");
		sb.append("                        TO_CHAR(REVIEW_DATE, 'YYYY/MM/DD HH24:MI:SS') REVIEW_DATE");
		sb.append("                 FROM   REVIEW");
		sb.append("                 ORDER BY REVIEW_NO DESC))");
		sb.append(" WHERE  request_page = ?");
		
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setInt(1, page);
			rs = pstmt.executeQuery();
			list = new ArrayList<Review>();
			
			while(rs.next()){
				Review review = createReview(rs);
				list.add(review);
			}
				
			System.out.println("listByPage 완료");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null)    rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null)   con.close();
			} catch (Exception e) {}
		}
		return list;
	}
	
	
	/** 출력페이지 계산을 위한 {검색유형, 검색값}에 대한 행의 수 반환 */
	public int pageCount(Params params) {
		int count = 0;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT COUNT(REVIEW_NO) count");
		sb.append(" FROM   REVIEW");
		
		// 검색 유형별 WHERE 절 동적 추가
		String type = params.getType();
		String value = params.getValue();
				
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sb.toString());

			// 전체검색이 아닌경우 경우
			if(type != null){
				pstmt.setString(1, value);
			}

			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				count = rs.getInt("count");
			}
			
			System.out.println("pageCount 완료");
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("JdbcUserDao.pageCount(Params params) 실행 중 예외발생", e);
		} finally {
			try {
				if(rs != null)    rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null)   con.close();
			} catch (Exception e) {}
		}
		return count;
	}

	
}
