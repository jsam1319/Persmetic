package kr.or.kosta.leaf.product.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import kr.or.kosta.leaf.common.web.Params;
import kr.or.kosta.leaf.product.domain.Product;

/**
 * 상품(product) 테이블 관련 DAO 클래스
 * 
 * ************************
 * 2017-09-30 - 이재현
 * 메소드 명 변경(search_product -> read)
 * read 내 에러 변경(rs.getString(productCode) -> rs.getString(product_code)
 * 
 * ************************
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
				"        		 	       CATEGORY_NO, \r\n" + 
				"          		 	       PRODUCT_IMAGE," +
				"						   PRODUCT_TYPE)" +
			"VALUES ((SELECT max(PRODUCT_CODE) from PRODUCT)+1, ?, ?, ?, ?, ?, ?, ?, ?, ?, '1')";

		try {
			con = dataSource.getConnection();
			con.setAutoCommit(false);

			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, product.getProductName());
			pstmt.setString(2, product.getProductExplain());
			pstmt.setString(3, product.getProductBrand());
			pstmt.setString(4, product.getProductColor());
			pstmt.setString(5, product.getProductTone());
			pstmt.setInt(6, product.getProductPrice());
			pstmt.setInt(7, product.getProductSow());
			pstmt.setInt(8, product.getCategoryNo());
			pstmt.setString(9, product.getProductImage());
			
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
	
	/** 상품 전체 리스트 */
	@Override
	public List<Product> listAll() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<Product> products = new ArrayList<Product>();

		String sql = " SELECT PRODUCT_CODE, "
									 + " PRODUCT_NAME, "
									 + " PRODUCT_EXPLAIN, "
									 + " PRODUCT_BRAND, "
									 + " PRODUCT_COLOR, "
									 + " PRODUCT_TONE, "
									 + " PRODUCT_PRICE,  "
									 + " PRODUCT_SOW, "
									 + " CATEGORY_NO, "
									 + " PRODUCT_IMAGE \r\n" + 
							"FROM PRODUCT \r\n" ;

		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				Product product = new Product();
				
				product.setProductCode(rs.getInt("product_code"));
				product.setProductName(rs.getString("product_name"));
				product.setProductExplain(rs.getString("product_explain"));
				product.setProductBrand(rs.getString("product_brand"));
				product.setProductColor(rs.getString("product_color"));
				product.setProductTone(rs.getString("product_tone"));
				product.setProductPrice(rs.getInt("product_price"));
				product.setProductSow(rs.getInt("product_sow"));
				product.setCategoryNo(rs.getInt("category_no"));
				product.setProductImage(rs.getString("product_image"));
				
				products.add(product);
			}
			System.out.println("read 완료!");
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("JdbcProductDao read(ProductCode) 실행 중 예외발생", e);
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
		
		return products;
	}
	
	
	
	/** 상품 상세보기  */
	/*public Product read(int productCode) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM product p, (SELECT ROUND(AVG(r.review_grade), 0) gradeAvg\r\n" + 
				"            FROM review r\r\n" + 
				"            WHERE product_code=?\r\n" + 
				"            group by r.product_code)\r\n" + 
				"where product_code = ?";


		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, productCode);
			pstmt.setInt(2, productCode);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				Product product = new Product();
				product.setProductCode(rs.getInt("product_code"));
				product.setProductName(rs.getString("product_name"));
				product.setProductExplain(rs.getString("product_explain"));
				product.setProductBrand(rs.getString("product_brand"));
				product.setProductColor(rs.getString("product_color"));
				product.setProductTone(rs.getString("product_tone"));
				product.setProductPrice(rs.getInt("product_price"));
				product.setProductSow(rs.getInt("product_sow"));
				product.setCategoryNo(rs.getInt("category_no"));
				product.setProductImage(rs.getString("product_image"));
				product.setGrade(rs.getString("gradeAvg"));
				
				return product;
			}
			System.out.println("read 완료!");
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("JdbcProductDao read(ProductCode) 실행 중 예외발생", e);
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
	}*/

	/** 상품 상세보기  */
	public Product read(int productCode) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = " SELECT PRODUCT_CODE, "
									 + " PRODUCT_NAME, "
									 + " PRODUCT_EXPLAIN, "
									 + " PRODUCT_BRAND, "
									 + " PRODUCT_COLOR, "
									 + " PRODUCT_TONE, "
									 + " PRODUCT_PRICE,  "
									 + " PRODUCT_SOW, "
									 + " CATEGORY_NO, "
									 + " PRODUCT_IMAGE \r\n" + 
				"FROM PRODUCT \r\n" + 
				"WHERE PRODUCT_CODE = ?";

		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, productCode);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				Product product = new Product();
				product.setProductCode(rs.getInt("product_code"));
				product.setProductName(rs.getString("product_name"));
				product.setProductExplain(rs.getString("product_explain"));
				product.setProductBrand(rs.getString("product_brand"));
				product.setProductColor(rs.getString("product_color"));
				product.setProductTone(rs.getString("product_tone"));
				product.setProductPrice(rs.getInt("product_price"));
				product.setProductSow(rs.getInt("product_sow"));
				product.setCategoryNo(rs.getInt("category_no"));
				product.setProductImage(rs.getString("product_image"));
				System.out.println(product);
				return product;
			}
			System.out.println("read 완료!");
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("JdbcProductDao read(ProductCode) 실행 중 예외발생", e);
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


	
	/** 상품정보 수정 */
	public void update(Product product) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE PRODUCT SET PRODUCT_NAME =?, PRODUCT_EXPLAIN=?, PRODUCT_BRAND=?, PRODUCT_COLOR=?, PRODUCT_TONE=?, PRODUCT_PRICE=?, PRODUCT_SOW=?, CATEGORY_NO=?, PRODUCT_IMAGE=? WHERE PRODUCT_CODE=?";
		try {
			con = dataSource.getConnection();
			con.setAutoCommit(false);
			

			System.out.println(con);
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, product.getProductName());
			pstmt.setString(2, product.getProductExplain());
			pstmt.setString(3, product.getProductBrand());
			pstmt.setString(4, product.getProductColor());
			pstmt.setString(5, product.getProductTone());
			pstmt.setInt(6, product.getProductPrice());
			pstmt.setInt(7, product.getProductSow());
			pstmt.setInt(8, product.getCategoryNo());
			pstmt.setString(9, product.getProductImage());
			pstmt.setInt(10, product.getProductCode());
			
			
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
		int productCode = rs.getInt("product_code");
		String productName = rs.getString("product_name");
		String productExplain = rs.getString("product_explain");
		String productBrand = rs.getString("product_brand");
		String productColor = rs.getString("product_color");
		String productTone = rs.getString("product_tone");
		int productPrice = rs.getInt("product_price");
		int productSow = rs.getInt("product_sow");
		int productHits = rs.getInt("product_hits");
		int categoryNo = rs.getInt("category_no");
		String productImage = rs.getString("product_image");
		
		Product product = new Product();
		
		product.setProductCode(productCode);
		product.setProductName(productName);
		product.setProductExplain(productExplain);
		product.setProductBrand(productBrand);
		product.setProductColor(productColor);
		product.setProductTone(productTone);
		product.setProductPrice(productPrice);
		product.setProductSow(productSow);
		product.setProductHits(productHits);
		product.setCategoryNo(categoryNo);
		product.setProductImage(productImage);
		
		return product;
	}
	
	
	/** 카테고리에 대한 상품목록 반환 */
	public List<Product> listByParams(Params params, int categoryNo) {
		List<Product> list = null;		
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT a.*");
		sb.append(" FROM (SELECT CEIL(rownum / ?) request_page, at.*");
		sb.append("	  	  FROM (SELECT *");
		sb.append("		  FROM product");
		sb.append("		  WHERE category_no=?");
		sb.append("		  ORDER BY product_code DESC)at)a");
		sb.append(" WHERE request_page = ?");
		
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setInt(1, params.getPageSize());
			pstmt.setInt(2, categoryNo);
			pstmt.setInt(3, params.getPage());
			
			rs = pstmt.executeQuery();
			list = new ArrayList<Product>();
			
			while(rs.next()){
				Product prduct = createProduct(rs);
				list.add(prduct);
			}
			System.out.println("listByParams 완료");
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("JdbcProductDao.listByParams(Params params) 실행 중 예외발생", e);
		} finally {
			try {
				if(rs != null)    rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null)   con.close();
			} catch (Exception e) {}
		}
		return list;
	}
	

	/** 톤에 대한 상품목록 반환 */
	public List<Product> listByTone(Params params, String tone) {
		List<Product> list = null;		
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT a.*");
		sb.append(" FROM (SELECT CEIL(rownum / ?) request_page, at.*");
		sb.append(" 	  FROM (SELECT *");
		sb.append("		    	FROM product");
		sb.append("		    	WHERE product_tone=?");
		sb.append("		    	ORDER BY product_code DESC)at)a");
		sb.append(" WHERE request_page = ?");
		
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setInt(1, params.getPageSize());
			pstmt.setString(2, tone);
			pstmt.setInt(3, params.getPage());
			
			rs = pstmt.executeQuery();
			list = new ArrayList<Product>();
			
			while(rs.next()){
				Product prduct = createProduct(rs);
				list.add(prduct);
			}
			System.out.println("listByParams 완료");
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("JdbcProductDao.listByTone(Params params) 실행 중 예외발생", e);
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
	public int pageCountctn(int categoryNo) {
		int count = 0;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT COUNT(PRODUCT_CODE) count");
		sb.append(" FROM   PRODUCT");
		sb.append(" WHERE  category_no=?");
		
				
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sb.toString());
			
			pstmt.setInt(1, categoryNo);

			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				count = rs.getInt("count");
			}
			System.out.println("pageCount 완료");
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("JdbcProductDao.pageCount(Params params) 실행 중 예외발생", e);
		} finally {
			try {
				if(rs != null)    rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null)   con.close();
			} catch (Exception e) {}
		}
		return count;
	}
	
	/** 출력페이지 계산을 위한 {검색유형, 검색값}에 대한 행의 수 반환 */
	public int pageCounttone(String tone) {
		int count = 0;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT COUNT(PRODUCT_CODE) count");
		sb.append(" FROM   PRODUCT");
		sb.append(" WHERE  product_tone=?");
		
				
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sb.toString());
			
			pstmt.setString(1, tone);

			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				count = rs.getInt("count");
			}
			System.out.println("pageCount 완료");
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("JdbcProductDao.pageCount(Params params) 실행 중 예외발생", e);
		} finally {
			try {
				if(rs != null)    rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null)   con.close();
			} catch (Exception e) {}
		}
		return count;
	}
	
	public int getMaxProductCode() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT max(PRODUCT_CODE) max_no from PRODUCT";

		try {
			con = dataSource.getConnection();
			con.setAutoCommit(false);

			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) return rs.getInt("max_no");
			
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
		return -1;
	}
	
	
	
	
}
