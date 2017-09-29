package kr.or.kosta.leaf.product_inquiry.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import kr.or.kosta.leaf.common.db.DaoFactory;
import kr.or.kosta.leaf.product.domain.Product;
import kr.or.kosta.leaf.product_inquiry.domain.ProductInquiry;

/**
 * 상품문의 관련 DAO 클래스
 *
 * @author 박연주
 *
 */

public class JdbcProductInquiryDao implements ProductInquiryDao {
	private DataSource dataSource;

	public JdbcProductInquiryDao() {
	}

	public JdbcProductInquiryDao(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	
	/** 상품문의등록 */
	public void create(ProductInquiry inquiry) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		
		String sql = "INSERT INTO PRODUCT_INQUIRY(INQUIRY_NO,\r\n" + 
				"         				   INQUIRY_TITLE,\r\n" + 
				"          			 	   INQUIRY_CONTENTS,\r\n" + 
				"         		 	       PRODUCT_CODE,\r\n" + 
				"        		 	       CTM_NO)" + 
				"VALUES ((SELECT max(INQUIRY_NO) from PRODUCT_INQUIRY)+1, ?, ?, ?, ?)";

		try {
			con = dataSource.getConnection();
			con.setAutoCommit(false);

			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, inquiry.getInquiryTitle());
			pstmt.setString(2, inquiry.getInquiryContents());
			pstmt.setInt(3, inquiry.getProductCode());
			pstmt.setInt(4, inquiry.getCtmNo());
			
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
	
	/** 상품정보 삭제 */
	public void delete(int inquiryno) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM PRODUCT_INQUIRY WHERE INQUIRY_NO=?";
		
		try {
			con = dataSource.getConnection();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, inquiryno);
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
	
	public static void main(String[] args) {
		ProductInquiryDao dao = (ProductInquiryDao) DaoFactory.getInstance().getDao(JdbcProductInquiryDao.class);
		
		//ProductInquiry inq = new ProductInquiry("문의제목", "문의내용", 1, 2);
		
	//	dao.create(inq);
		
		dao.delete(2);
	}
	
	

	
}
