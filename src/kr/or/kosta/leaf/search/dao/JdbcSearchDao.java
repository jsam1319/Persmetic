package kr.or.kosta.leaf.search.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import kr.or.kosta.leaf.product.domain.Product;

public class JdbcSearchDao implements SearchDao {
	
	private DataSource dataSource;


	public JdbcSearchDao(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}

	public JdbcSearchDao() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	

	@Override
	public List<Product> listByKeyword(String[] keywordNames) {
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
						" FROM PRODUCT \r\n" + 
						" WHERE product_code IN ";

		try {
			con = dataSource.getConnection();
			
			sql = sql + createWhereSql(keywordNames);
			
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
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("public List<Product> listByKeyword(String[] keywordNames) 실행 중 예외발생", e);
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
	
	private String createWhereSql(String[] keywordNames) {
		String sql = "( ";
		
		for (int i=0; i<keywordNames.length; i++) {
			if(i != keywordNames.length-1) 
				sql = sql + " SELECT  product_code FROM keyword WHERE keyword_name like '%" + keywordNames[i] + "%' INTERSECT";
			else 
				sql = sql + " SELECT  product_code FROM keyword WHERE keyword_name like '%" + keywordNames[i] + "%' )";
		}
		
		return sql;
	}

}
