package kr.or.kosta.leaf.review.service;

import java.util.List;

import kr.or.kosta.leaf.common.web.Params;
import kr.or.kosta.leaf.product.domain.Product;
import kr.or.kosta.leaf.review.domain.Review;

public interface ReviewService {

	public void create(Review review);
	
	public List<Review> listByParams(Params params);

	public int pageCount(Params params);
	
	public Review read(int reviewNo);
	
}
