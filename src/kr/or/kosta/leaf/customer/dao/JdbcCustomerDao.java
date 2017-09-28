package kr.or.kosta.leaf.customer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import kr.or.kosta.leaf.customer.domain.Customer;

public class JdbcCustomerDao implements CustomerDao {

	private DataSource dataSource;

	public JdbcCustomerDao() {
	}

	public JdbcCustomerDao(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	/** 신규 회원 등록 */
	@Override
	public void create(Customer Customer) {
		Connection con = null;
		PreparedStatement pstmt = null;

		String sql = " INSERT INTO customer " 
		           + "             (ctm_no," 
				   + "              ctm_name,"
				   + "              ctm_division," 
				   + "              ctm_id," 
				   + "              ctm_passwd,"
				   + "              ctm_age," 
				   + "              ctm_gender," 
				   + "              ctm_address,"
				   + "              ctm_tone," 
				   + "              ctm_job," 
				   + "              ctm_email)" 
				   + " VALUES      (?,"
				   + "              ?," 
				   + "              ?," 
				   + "              ?," 
				   + "              ?," 
				   + "              ?,"
				   + "              ?," 
				   + "              ?," 
				   + "              ?," 
				   + "              ?,"
				   + "              ?)";

		try {
			con = dataSource.getConnection();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, Customer.getCtm_no());
			pstmt.setString(2, Customer.getCtm_name());
			pstmt.setString(3, Customer.getCtm_division());
			pstmt.setString(4, Customer.getCtm_id());
			pstmt.setString(5, Customer.getCtm_passwd());
			pstmt.setInt(6, Customer.getCtm_age());
			pstmt.setString(7, Customer.getCtm_gender());
			pstmt.setString(8, Customer.getCtm_address());
			pstmt.setString(9, Customer.getCtm_tone());
			pstmt.setString(10, Customer.getCtm_job());
			pstmt.setString(11, Customer.getCtm_email());

			pstmt.executeUpdate();

			con.commit();
		} catch (Exception e) {
			e.printStackTrace();

			try {
				con.rollback();
			} catch (SQLException e1) {
			}
			throw new RuntimeException("JdbcCustomerDao.create(Customer) 실행 중 예외발생", e);
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception e) {
			}
		}
	}

	/** 전체 회원목록 반환 */
	@Override
	public List<Customer> listAll() {
		List<Customer> list = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = " SELECT ctm_no, " 
		           + "        ctm_name," 
				   + "        ctm_division," 
		           + " 	      ctm_id,"
			       + "        ctm_passwd," 
		           + "        TO_CHAR(ctm_regdate, 'YYYY/MM/DD HH24:MI:SS') ctm_regdate,"
				   + "        ctm_age," 
		           + "        ctm_gender," 
				   + "        ctm_address," 
		           + "        ctm_tone,"
				   + "        ctm_job" 
		           + " FROM   customer" 
				   + " ORDER BY ctm_regdate DESC";

		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			list = new ArrayList<Customer>();

			while (rs.next()) {
				Customer Customer = createCustomer(rs);
				list.add(Customer);
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

	/** 사용자아이디를 이용한 사용자 상세 정보 조회 */
	@Override
	public Customer read(String ctm_id) {
		Customer Customer = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "SELECT ctm_no, " 
				   + "       ctm_name, " 
				   + "       ctm_division, " 
				   + "       ctm_id, "
				   + "       ctm_passwd, " 
				   + "       TO_CHAR(ctm_regdate, 'YYYY-MM-DD HH24:MI:SS') ctm_regdate, "
				   + "       ctm_age, " 
				   + "       ctm_gender, " 
				   + "       ctm_address, " 
				   + "       ctm_tone, "
				   + "       ctm_job, " 
				   + "       ctm_email " 
				   + "FROM   customer " 
				   + "WHERE  ctm_id = ?";
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, ctm_id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				Customer = createCustomer(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("JdbcCustomerDao.read(String ctm_id) 실행 중 예외발생", e);
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
		return Customer;
	}

	/** 회원 여부 반환 */
	@Override
	public Customer isMember(String ctm_id, String ctm_passwd) {
		Customer Customer = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "SELECT ctm_no, " 
		           + "       ctm_name, " 
				   + "       ctm_division, " 
		           + "       ctm_id, "
				   + "       ctm_passwd, " 
		           + "       TO_CHAR(ctm_regdate, 'YYYY/MM/DD') ctm_regdate , "
				   + "       ctm_age, " 
		           + "       ctm_gender, " 
				   + "       ctm_address, " 
		           + "       ctm_tone, "
				   + "       ctm_job, " 
		           + "       ctm_email" 
				   + "FROM   customer " 
				   + "WHERE  ctm_id = ? AND ctm_passwd = ?";
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, ctm_id);
			pstmt.setString(2, ctm_passwd);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				Customer = createCustomer(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("JdbcCustomerDao.isMember(ctm_id, ctm_passwd) 실행 중 예외발생", e);
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
		return Customer;
	}

	/** 회원 탈퇴 - 비밀번호 확인 */
	@Override
	public boolean deleteConfirm(String ctm_id, String ctm_passwd) {

		boolean confirmPw = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "SELECT * from customer "
					+ "	WHERE ctm_id = ? " 
					+ "	AND ctm_passwd = ?";

		try {
			con = dataSource.getConnection();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, ctm_id);
			pstmt.setString(2, ctm_passwd);

			rs = pstmt.executeQuery();

			if (rs.next())
				confirmPw = true;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("JdbcCustomerDao.deleteConfirm(ctm_id, ctm_passwd) 실행 중 예외발생", e);
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
		return confirmPw;
	}

	/** 회원삭제 */
	@Override
	public void deleteCustomer(String ctm_id) {
		Connection con = null;
		PreparedStatement pstmt = null;

		String sql = " DELETE FROM customer " +
		             	   " WHERE ctm_id = ?";

		try {
			con = dataSource.getConnection();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, ctm_id);
			
			pstmt.executeUpdate();
			
			con.commit();
		} catch (Exception e) {
			e.printStackTrace();
			
			try {
				con.rollback();
			} catch (SQLException e1) {}
			throw new RuntimeException("JdbcCustomerDao.deleteCustomer(String ctm_id) 실행 중 예외발생", e);
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null)   con.close(); 
			} catch (Exception e) {}
		}
	}
	
	/** ID 중복 체크 */
	   public boolean checkId(String ctm_id) {
	      Connection con = null;
	      PreparedStatement pstmt = null;
	      ResultSet rs = null;
	      
	      boolean confirmId = false;
	      
	      String sql = "SELECT ctm_id "
	      		     + "FROM   customer "
	      		     + "WHERE  ctm_id = ?";
	      
	      try {
	         con = dataSource.getConnection();
	         pstmt = con.prepareStatement(sql);
	         pstmt.setString(1, ctm_id);
	         rs = pstmt.executeQuery();
	         
	         confirmId = rs.next();
	      } catch(Exception e) {
	    	  throw new RuntimeException("JdbcCustomerDao.checkId(String ctm_id) 실행 중 예외발생", e);
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
	      return confirmId;
	   }
	

	private Customer createCustomer(ResultSet rs) throws SQLException {
		int ctm_no = rs.getInt("ctm_no");
		String ctm_name = rs.getString("ctm_name");
		String ctm_division = rs.getString("ctm_division");
		String ctm_id = rs.getString("ctm_id");
		String ctm_passwd = rs.getString("ctm_passwd");
		String ctm_regdate = rs.getString("ctm_regdate");
		int ctm_age = rs.getInt("ctm_age");
		String ctm_gender = rs.getString("ctm_gender");
		String ctm_address = rs.getString("ctm_address");
		String ctm_tone = rs.getString("ctm_tone");
		String ctm_job = rs.getString("ctm_job");
		String ctm_email = rs.getString("ctm_email");

		Customer Customer = new Customer();
		Customer.setCtm_no(ctm_no);
		Customer.setCtm_name(ctm_name);
		Customer.setCtm_division(ctm_division);
		Customer.setCtm_id(ctm_id);
		Customer.setCtm_passwd(ctm_passwd);
		Customer.setCtm_regdate(ctm_regdate);
		Customer.setCtm_age(ctm_age);
		Customer.setCtm_gender(ctm_gender);
		Customer.setCtm_address(ctm_address);
		Customer.setCtm_tone(ctm_tone);
		Customer.setCtm_job(ctm_job);
		Customer.setCtm_email(ctm_email);
		return Customer;
	}
	
}
