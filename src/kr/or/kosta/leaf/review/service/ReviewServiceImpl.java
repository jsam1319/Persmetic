package kr.or.kosta.leaf.review.service;

import java.util.List;

import kr.or.kosta.leaf.common.db.DaoFactory;
import kr.or.kosta.leaf.common.web.Params;
import kr.or.kosta.leaf.product.dao.JdbcProductDao;
import kr.or.kosta.leaf.product.dao.ProductDao;
import kr.or.kosta.leaf.product.domain.Product;
import kr.or.kosta.leaf.review.dao.JdbcReviewDao;
import kr.or.kosta.leaf.review.dao.ReviewDao;
import kr.or.kosta.leaf.review.domain.Review;

public class ReviewServiceImpl implements ReviewService {

	ReviewDao reviewDao = (ReviewDao)DaoFactory.getInstance().getDao(JdbcReviewDao.class);
	
	@Override
	public void create(Review review) {
		reviewDao.create(review);
	}

	@Override
	public List<Review> listByParams(Params params){
		return reviewDao.listByParams(params);
	}
	
	@Override
	public int pageCount(Params params) {
		return reviewDao.pageCount(params);
	}
	
	@Override
	public Review read(int reviewNo) {
		return reviewDao.read(reviewNo);
	}
	
}
