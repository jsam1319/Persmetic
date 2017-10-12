package kr.or.kosta.leaf.suggest.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import kr.or.kosta.leaf.customer.domain.Customer;
import kr.or.kosta.leaf.customer.service.CustomerService;
import kr.or.kosta.leaf.customer.service.CustomerServiceImpl;
import kr.or.kosta.leaf.keyword.domain.Keyword;
import kr.or.kosta.leaf.keyword.service.KeywordService;
import kr.or.kosta.leaf.keyword.service.KeywordServiceImpl;
import kr.or.kosta.leaf.log.domain.Log;
import kr.or.kosta.leaf.log.domain.LogType;
import kr.or.kosta.leaf.log.service.LogService;
import kr.or.kosta.leaf.log.service.LogServiceImpl;
import kr.or.kosta.leaf.product.domain.Product;
import kr.or.kosta.leaf.product.service.ProductService;
import kr.or.kosta.leaf.product.service.ProductServiceImpl;

/**
 * 상품 간 유사도를 계산하는 유틸 클래스
 * 유사도의 보존
 * 
 * 
 * @author 이재현
 *
 */

public class SimilarityUtil {

	List<Product> products = null;
	private static Map<Integer, SimilarityUtil> SimilarityUtils = new HashMap<Integer, SimilarityUtil>();
	
	private double [][]similarity = null;
	private int ctmNo;
	
	public SimilarityUtil(int ctmNo) {
		this.ctmNo = ctmNo;
		
		ProductService ps = new ProductServiceImpl();
		products = ps.listAll();
		
		getSimil(products);
		
	}
	
	public double getSimilarity(int x, int y) {
		return similarity[x][y];
	}
	
	
	private void getSimil(List<Product> products) {
		if(similarity == null) 
			similarity = new double[products.size()][products.size()];
		
		for(int i=0; i<products.size(); i++) {
			for(int j=0; j<products.size(); j++) {
				if(i == j) {
					if(findIndexByCode(i, products) == -1) continue;
					similarity[i][j] = computeCustomerScore(products.get(findIndexByCode(i, products)), ctmNo);
					continue;
				}
				if(findIndexByCode(i, products) == -1) continue;
				if(findIndexByCode(j, products) == -1) continue;
				similarity[i][j] = computeSimil(products.get(findIndexByCode(i, products)), products.get(findIndexByCode(j, products)));
			}
		}
	}
	
	private int findIndexByCode(int code, List<Product> products) {
		for(int i=0; i<products.size(); i++) {
			if(products.get(i).getProductCode() == code+4) return i;
		}
		
		return -1;
	}
	
	/**
	 * 두 프로덕트에 관한 유사도를 계산해 주는 메소드
	 * 각 조건에 따라 유사도를 추가하고 감산한다.
	 * @param pro1
	 * @param pro2
	 * @return
	 */
	private double computeSimil(Product pro1, Product pro2) {
		double score = 0.0;
		
		if(pro1.getCategoryNo() == pro2.getCategoryNo()) 	{
			if(pro1.getProductTone() == pro2.getProductTone())		score = score + 1.12;
			else																			score = score + 0.35; 
			
			score = score + (1000 -getColorDiff(pro1.getProductColor(),pro2.getProductColor())) * 0.007;
		}
		
		else {
			score = score + (1000 -getColorDiff(pro1.getProductColor(),pro2.getProductColor())) * 0.005;
			
			if(pro1.getProductTone() == pro2.getProductTone())		score = score + 0.613;
		}
		
		if(pro1.getProductBrand() == pro2.getProductBrand()) 		score = score + 0.528;
		
		return score;
	}
	 
	public int[] getSuggest(Product product) {
		System.out.println(product);
		
		int productCode = product.getProductCode()-4;
		
		double[] reserve = new double[similarity[productCode].length];
		for (int i=0; i<reserve.length; i++) {
			reserve[i] = similarity[productCode][i];
		}
		
		LogService ls = new LogServiceImpl();
		List<Log> logs = ls.listLog(ctmNo);
		
		for (int i=0; i<reserve.length; i++) {
			reserve[i] = reserve[i] * getRandomNum();
		}
		
		for (Log log : logs) {
			if(log.getLogType() == LogType.BUY) {
				String[] split = log.getLogContent().split(",");
				
				for (String string : split) {
					reserve[Integer.parseInt(string)] = 0;
				}
			}
		}
		
		
		int[] most = new int[6];
		
		double mine = reserve[productCode];
		reserve[productCode] = 0.0;
		
		for(int i=0; i<reserve.length; i++) {
			reserve[i] = reserve[i] + mine;
		}
		
		double[] copy = new double[reserve.length];
		
		for (int i=0; i<reserve.length; i++) {
			copy[i] = reserve[i];
		}	
		
		
		Arrays.sort(reserve);
		
		
		for(int i=0; i<6; i++) {
			most[i] = search(copy, reserve[reserve.length-1-i]) + 5;
		}
		
		System.out.println(Arrays.toString(most));
		return most;
	}
	
	private int search(double[] copy, double value) {
		for(int i=0; i<copy.length; i++) {
			if(copy[i] == value) return i;
		}
		
		return -1;
	}
	
	public int getMostItem(int ctmNo) {
		LogService ls = new LogServiceImpl();
		List<Log> logs = ls.listLog(ctmNo);
		
		int temp[] = new int[100];
		
		for (Log log : logs) {
			if(log.getLogType() == LogType.CART_INSERT) {
				temp[Integer.parseInt(log.getLogContent())]++;
			}
			
			else if(log.getLogType() == LogType.BUY) {
				String[] split = log.getLogContent().split(",");
				
				for (String string : split) {
					System.out.println(string);
					temp[Integer.parseInt(string)]++;
				}
			}
		}
		int max = 0;
		
		for(int i=0; i<100; i++) {
			if(temp[i] > max) max = i;
		}
		
		System.out.println("MAX : " + max);
		return max;
	}
	
	
	private double computeCustomerScore(Product pro, int ctmNo) {
		LogService ls = new LogServiceImpl();
		List<Log> logs = ls.listLog(ctmNo);
		
		CustomerService cs = new CustomerServiceImpl();
		Customer ctm = cs.read(ctmNo);
		
		KeywordService ks = new KeywordServiceImpl();
		List<Keyword> keys = ks.getKeyword(pro.getProductCode());
		int keywordScore = 0;
		
		double score = 0.0;
		String tone = ctm.getCtmTone();
		if(tone == null) tone = "쿨톤";
		if(tone.equals(pro.getProductTone())) score = score + 0.425;
		
		List<String> logString = new ArrayList<String>();
		
		for(Log log : logs) {
			if(log.getLogType().equals(LogType.SEARCH)) 
				logString.add(log.getLogContent());
		}
		
		for (String string : logString) {
			for(int i=0; i<keys.size(); i++) {
				if(keys.get(i).getKeywordName().equals(string)) {
					keywordScore++;
					break;
				}
			}
		}
		
		score = score + (keywordScore * 0.4815);
		
		return score;
	}
	
	private double getRandomNum() {
		Random random = new Random();
		
		String randString = "1.0001" + String.valueOf(random.nextInt(100) +1);

		return Double.parseDouble(randString);
	}
	
	private double getColorDiff(String color1, String color2) {
		String red1 = color1.charAt(1) + "" + color1.charAt(2) + "";
		String red2 = color2.charAt(1) + "" +  color2.charAt(2) + "";
		
		String green1 = color1.charAt(3) + "" +  color1.charAt(4) + "";
		String green2 = color2.charAt(3) + "" +  color2.charAt(4) + "";
		
		String blue1 = color1.charAt(5) + "" +  color1.charAt(6) + "";
		String blue2 = color2.charAt(5) + "" +  color2.charAt(6) + "";
		
		int redValue = (Integer.valueOf(red2, 16) - Integer.valueOf(red1, 16)) * (Integer.valueOf(red2, 16) - Integer.valueOf(red1, 16)) * 2;
		int greenValue = (Integer.valueOf(green2, 16) - Integer.valueOf(green1, 16)) * (Integer.valueOf(green2, 16) - Integer.valueOf(green1, 16)) * 4;
		int blueValue = (Integer.valueOf(blue2, 16) - Integer.valueOf(blue1, 16)) * (Integer.valueOf(blue2, 16) - Integer.valueOf(blue1, 16)) * 3;
		
		return Math.sqrt(redValue + greenValue + blueValue) ;
	}
}
