package kr.or.kosta.leaf.product_answer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import kr.or.kosta.leaf.common.db.DaoFactory;
import kr.or.kosta.leaf.product_answer.domain.ProductAnswer;

/**
 * 상품문의답변 테이블 관련 DAO 클래스
 *
 * @author 박연주
 *
 */

public class JdbcProductAnswerDao implements ProductAnswerDao {
	private DataSource dataSource;

	public JdbcProductAnswerDao() {
	}

	public JdbcProductAnswerDao(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	/** 상품문의답변등록 */
	public void create(ProductAnswer answer) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		
		String sql = "INSERT INTO PRODUCT_ANSWER(ANSWER_NO,\r\n" + 
				"         				   ANSWER_TITLE,\r\n" + 
				"          			 	   ANSWER_CONTENTS,\r\n" + 
				"        		 	       INQUIRY_NO)" + 
				"VALUES ((SELECT max(ANSWER_NO) from PRODUCT_ANSWER)+1, ?, ?, ?)";

		try {
			con = dataSource.getConnection();
			con.setAutoCommit(false);

			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, answer.getAnswerTitle());
			pstmt.setString(2, answer.getAnswerContents());
			pstmt.setInt(3, answer.getInquiryNo());
			
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
	
	/** 상품문의답변 삭제 */
	public void delete(int answerno) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = " DELETE FROM PRODUCT_ANSWER WHERE ANSWER_NO=?";
		
		try {
			con = dataSource.getConnection();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, answerno);
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
	

	
	
}	
