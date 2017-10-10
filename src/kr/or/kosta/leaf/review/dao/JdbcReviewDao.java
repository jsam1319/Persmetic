package kr.or.kosta.leaf.review.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import kr.or.kosta.leaf.common.web.Params;
import kr.or.kosta.leaf.customer.domain.Customer;
import kr.or.kosta.leaf.product.domain.Product;
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
	
	/** 리뷰 내용보기  */
	public Review read(int reviewNo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = " SELECT REVIEW_NO, CTM_NO, PRODUCT_CODE, REVIEW_GRADE, REVIEW_TITLE, REVIEW_CONTENTS, REVIEW_DATE " +
				"FROM REVIEW \r\n" + 
				"WHERE REVIEW_NO = ?";
		 
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, reviewNo);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				Review review = new Review();
				
				review.setReviewNo(rs.getInt("review_no"));
				review.setCtmNo(rs.getInt("ctm_no"));
				review.setProductCode(rs.getInt("product_code"));
				review.setReviewGrade(rs.getInt("review_grade"));
				review.setReviewTitle(rs.getString("review_title"));
				review.setReviewContents(rs.getString("review_contents"));
				review.setReviewDate(rs.getString("review_date"));
				
				return review;
			}
			System.out.println("read 완료!");
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("JdbcReviewDao read(ReviewNo) 실행 중 예외발생", e);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
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
		int reviewNo = rs.getInt("REVIEW_NO");
		int ctmNo = rs.getInt("CTM_NO");
		int productCode = rs.getInt("PRODUCT_CODE");
		int reviewGrade = rs.getInt("REVIEW_GRADE");
		String reviewTitle = rs.getString("REVIEW_TITLE");
		String reviewContents = rs.getString("REVIEW_CONTENTS");
		String reviewDate = rs.getString("REVIEW_DATE");
		String ctmId = rs.getString("CTM_ID");
		String productName = rs.getString("PRODUCT_NAME");

		Review review = new Review();
		review.setReviewNo(reviewNo);
		review.setCtmNo(ctmNo);
		review.setProductCode(productCode);
		review.setReviewGrade(reviewGrade);
		review.setReviewTitle(reviewTitle);
		review.setReviewContents(reviewContents);
		review.setReviewDate(reviewDate);
		review.setCtmId(ctmId);
		review.setProductName(productName);

		return review;
	}

	
	/** 선택 페이지에 대한 리뷰목록 반환 */
	public List<Review> listByParams(Params params, int productCode) {
		List<Review> list = null;	
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT a.*");
		sb.append(" FROM   (SELECT CEIL(rownum / ?) request_page,");
		sb.append("                at.*");
		sb.append("         FROM   (SELECT r.*,");
		sb.append("                        c.ctm_id,");
		sb.append("                        p.product_name");
		sb.append("                 FROM   review r, customer c, product p");
		sb.append("                 WHERE  r.ctm_no=c.ctm_no and r.product_code=p.product_code");
		sb.append("                 AND		r.product_code=p.product_code");
		sb.append("                 AND		p.product_code=?");
		sb.append(" 				ORDER BY REVIEW_NO DESC)at)a");
		sb.append(" WHERE  request_page = ?");
		
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setInt(1, params.getPageSize());
			pstmt.setInt(2, productCode);
			pstmt.setInt(3, params.getPage());
			
			rs = pstmt.executeQuery();
			list = new ArrayList<Review>();
			
			while(rs.next()){
				Review review = createReview(rs);
				list.add(review);
			}
			System.out.println("listByParams 완료");
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("JdbcReviewDao.listByParams(Params params) 실행 중 예외발생", e);
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
	public int pageCount(Params params, int productCode) {
		int count = 0;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT COUNT(REVIEW_NO) count");
		sb.append(" FROM   REVIEW");
		sb.append(" WHERE	product_code=?");
		
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sb.toString());
			
			pstmt.setInt(1, productCode);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				count = rs.getInt("count");
			}
			
			System.out.println("pageCount 완료");
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("JdbcReviewDao.pageCount(Params params) 실행 중 예외발생", e);
		} finally {
			try {
				if(rs != null)    rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null)   con.close();
			} catch (Exception e) {}
		}
		return count;
	}
	
	/** 상품별 리뷰목록 반환 */
	   @Override
	   public List<Review> listAll(int productCode) {
	      List<Review> list = null;

	      Connection con = null;
	      PreparedStatement pstmt = null;
	      ResultSet rs = null;
	      
	      String sql = "SELECT r.*, p.product_name, c.ctm_id\r\n" + 
	      		"	    FROM review r, product p, customer c\r\n" + 
	      		"	    WHERE r.product_code=p.product_code " +
	      		"				AND r.ctm_no=c.ctm_no" +
	      		"				AND r.product_code=?" +
	      		"		ORDER BY review_no DESC";


	      try {
	         con = dataSource.getConnection();
	         pstmt = con.prepareStatement(sql);
	         
	         pstmt.setInt(1, productCode);
	         
	         rs = pstmt.executeQuery();
	         list = new ArrayList<Review>();

	         while (rs.next()) {
	        	Review review = createReview(rs);
	            list.add(review);
	         }
	      } catch (Exception e) {
	         e.printStackTrace();
	         throw new RuntimeException("JdbcCustomerDao.listAll() 실행 중 예외발생", e);
	      } finally {
	         try {
	            if (rs != null)
	               rs.close();
	            if (pstmt != null)
	               pstmt.close();
	            if (con != null)
	               con.close();
	         } catch (Exception e) {
	         }
	      }
	      return list;
	   }

	
}
