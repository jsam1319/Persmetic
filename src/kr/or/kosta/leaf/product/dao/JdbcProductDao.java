package kr.or.kosta.leaf.product.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import kr.or.kosta.leaf.common.db.DaoFactory;
import kr.or.kosta.leaf.common.web.Params;
import kr.or.kosta.leaf.product.domain.Product;

/**
 * 상품(product) 테이블 관련 DAO 클래스
 * 
 * @author 박연주
 *
 */
public class JdbcProductDao implements ProductDao {
	private DataSource dataSource;

	public JdbcProductDao() {
	}

	public JdbcProductDao(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	

	/** 상품등록 */
	public void create(Product product) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO PRODUCT(PRODUCT_CODE,\r\n" + 
				"         				   PRODUCT_NAME,\r\n" + 
				"          			 	   PRODUCT_EXPLAIN,\r\n" + 
				"         		 	       PRODUCT_BRAND,\r\n" + 
				"        		 	       PRODUCT_COLOR,\r\n" + 
				"        		 	       PRODUCT_TONE,\r\n" + 
				"        		 	       PRODUCT_PRICE, \r\n" + 
				"        		 	       PRODUCT_SOW, \r\n" + 
				"          		 	       CATEGORY_NO)" +
				"VALUES ((SELECT max(PRODUCT_CODE) from PRODUCT)+1, ?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			con = dataSource.getConnection();
			con.setAutoCommit(false);

			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, product.getProduct_name());
			pstmt.setString(2, product.getProduct_explain());
			pstmt.setString(3, product.getProduct_brand());
			pstmt.setString(4, product.getProduct_color());
			pstmt.setString(5, product.getProduct_tone());
			pstmt.setInt(6, product.getProduct_price());
			pstmt.setInt(7, product.getProduct_sow());
			pstmt.setInt(8, product.getCategory_no());
			
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


	/** 상품 상세보기(번호로 정보 찾기) */
	public Product search_code(int productCode) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = " SELECT PRODUCT_CODE, PRODUCT_NAME, PRODUCT_EXPLAIN, PRODUCT_BRAND, PRODUCT_COLOR, PRODUCT_TONE, PRODUCT_PRICE,  PRODUCT_SOW, CATEGORY_NO \r\n" + 
				"FROM PRODUCT \r\n" + 
				"WHERE PRODUCT_CODE = ?";

		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, productCode);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				Product product = new Product();
				product.setProduct_code(rs.getInt("product_code"));
				product.setProduct_name(rs.getString("product_name"));
				product.setProduct_explain(rs.getString("product_explain"));
				product.setProduct_brand(rs.getString("product_brand"));
				product.setProduct_color(rs.getString("product_color"));
				product.setProduct_tone(rs.getString("product_tone"));
				product.setProduct_price(rs.getInt("product_price"));
				product.setProduct_sow(rs.getInt("product_sow"));
				product.setCategory_no(rs.getInt("category_no"));
				return product;
			}
			System.out.println("search_code 완료!");
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("JdbcProductDao(search_code) 실행 중 예외발생", e);
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

	
	/** 상품정보 삭제 */
	public void delete(int productcode) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM PRODUCT WHERE PRODUCT_CODE=?";
		
		try {
			con = dataSource.getConnection();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, productcode);
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


	//Product product = new Product(14, "test", "test", "test", "test", "test", 1000, 100, 100);
	
	/** 상품정보 수정 */
	public void update(Product product) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE PRODUCT SET PRODUCT_NAME =?, PRODUCT_EXPLAIN=?, PRODUCT_BRAND=?, PRODUCT_COLOR=?, PRODUCT_TONE=?, PRODUCT_PRICE=?, PRODUCT_SOW=? WHERE PRODUCT_CODE=?";
		try {
			con = dataSource.getConnection();
			con.setAutoCommit(false);
			

			System.out.println(con);
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, product.getProduct_name());
			pstmt.setString(2, product.getProduct_explain());
			pstmt.setString(3, product.getProduct_brand());
			pstmt.setString(4, product.getProduct_color());
			pstmt.setString(5, product.getProduct_tone());
			pstmt.setInt(6, product.getProduct_price());
			pstmt.setInt(7, product.getProduct_sow());
			pstmt.setInt(8, product.getProduct_code());
			
			System.out.println(pstmt.executeUpdate());
			
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
	
	/** 조회수 세기 */
	public void hitCount(int productcode) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE PRODUCT SET hitcount=hitcount+1 WHERE PRODUCT_CODE=?";

		try {
			con = dataSource.getConnection();
			con.setAutoCommit(false);

			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, productcode);
			
			pstmt.executeUpdate();

			System.out.println("hitCount 완료!");
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
	
	
	private Product createProduct(ResultSet rs) throws SQLException {
		int product_code = rs.getInt("product_code");
		String product_name = rs.getString("product_name");
		String product_explain = rs.getString("product_explain");
		String product_brand = rs.getString("product_brand");
		String product_color = rs.getString("product_color");
		String product_tone = rs.getString("product_tone");
		int product_price = rs.getInt("product_price");
		int product_sow = rs.getInt("product_sow");
		int product_hits = rs.getInt("product_hits");
		int category_no = rs.getInt("category_no");
		
		Product product = new Product();
		product.setProduct_code(product_code);
		product.setProduct_name(product_name);
		product.setProduct_explain(product_explain);
		product.setProduct_brand(product_brand);
		product.setProduct_color(product_color);
		product.setProduct_tone(product_tone);
		product.setProduct_price(product_price);
		product.setProduct_sow(product_sow);
		product.setProduct_hits(product_hits);
		product.setCategory_no(category_no);
		
		return product;
	}
	
	
	/** {선택페이지, 검색유형, 검색값, 한페이지당 출력 행수}에 대한 상품목록 반환 */
	public List<Product> listByParams(Params params) {
		List<Product> list = null;		
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT PRODUCT_CODE,");
		sb.append("        PRODUCT_NAME,");
		sb.append("        PRODUCT_EXPLAIN,");
		sb.append("        PRODUCT_BRAND,");
		sb.append("        PRODUCT_COLOR,");
		sb.append("        PRODUCT_TONE,");
		sb.append("        PRODUCT_PRICE,");
		sb.append("        PRODUCT_SOW,");
		sb.append("        PRODUCT_HITS,");
		sb.append("        CATEGORY_NO");
		sb.append(" FROM   (SELECT CEIL(rownum / ?) request_page,");
		sb.append("                PRODUCT_CODE,");
		sb.append("                PRODUCT_NAME,");
		sb.append("                PRODUCT_EXPLAIN,");
		sb.append("                PRODUCT_BRAND,");
		sb.append("                PRODUCT_COLOR,");
		sb.append("                PRODUCT_TONE,");
		sb.append("                PRODUCT_PRICE,");
		sb.append("                PRODUCT_SOW,");
		sb.append("                PRODUCT_HITS,");
		sb.append("                CATEGORY_NO");
		sb.append("         FROM   (SELECT PRODUCT_CODE,");
		sb.append("                        PRODUCT_NAME,");
		sb.append("                        PRODUCT_EXPLAIN,");
		sb.append("                        PRODUCT_BRAND,");
		sb.append("                        PRODUCT_COLOR,");
		sb.append("                        PRODUCT_TONE,");
		sb.append("                        PRODUCT_PRICE,");
		sb.append("                        PRODUCT_SOW,");
		sb.append("                        PRODUCT_HITS,");
		sb.append("                        CATEGORY_NO");
		sb.append("                 FROM   PRODUCT");
		
		// 검색 유형별 WHERE 절 동적 추가
		String type = params.getType();
		String value = params.getValue();
		if(type != null){
			switch (params.getType()) {
				case "name":    
					sb.append(" WHERE  PRODUCT_NAME  LIKE ?");
					break;
				case "brand":  
					sb.append(" WHERE  PRODUCT_BRAND LIKE ?");
					value = "%" + value + "%";
					break;
				case "color":   
					sb.append(" WHERE  PRODUCT_COLOR LIKE ?");
					value = "%" + value + "%";
					break;
				case "tone":   
					sb.append(" WHERE  PRODUCT_TONE LIKE ?");
					value = "%" + value + "%";
					break;
			}
		}
		sb.append(" ORDER BY PRODUCT_CODE ASC))");
		sb.append(" WHERE  request_page = ?");
		
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setInt(1, params.getPageSize());
			
			// 전체검색이 아닌경우 경우
			if(type != null){
				pstmt.setString(2, value);
				pstmt.setInt(3, params.getPage());
			}else{// 전체검색인 경우
				pstmt.setInt(2, params.getPage());
			}
			
			rs = pstmt.executeQuery();
			list = new ArrayList<Product>();
			
			while(rs.next()){
				Product prduct = createProduct(rs);
				list.add(prduct);
			}
			System.out.println("listByParams 완료");
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("JdbcUserDao.listByParams(Params params) 실행 중 예외발생", e);
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
		sb.append(" SELECT COUNT(article_id) count");
		sb.append(" FROM   article");
		
		// 검색 유형별 WHERE 절 동적 추가
		String type = params.getType();
		String value = params.getValue();
		if(type != null){
			switch (params.getType()) {
				case "writer":
					sb.append(" WHERE  writer  = ?");
					break;
				case "subject":
					sb.append(" WHERE  subject LIKE ?");
					value = "%" +value + "%";
					break;
				case "content":
					sb.append(" WHERE  content LIKE ?");
					value = "%" + value + "%";
					break;
			}
		}
				
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
	

	public static void main(String[] args) {
		ProductDao dao = (ProductDao) DaoFactory.getInstance().getDao(JdbcProductDao.class);
		
		//Product pro = new Product(0 , "testname", "testexplain", "testbrand", "testcolor", "testtone", 7000, 1000, 1);
		
		//dao.create(pro);
		
		//dao.delete(code);
		
		Product product = new Product(14, "test", "test", "test", "test", "test", 1000, 100);
		dao.update(product);
		
		//dao.hitCount(14);
	}
}
