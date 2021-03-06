package kr.or.kosta.leaf.review.service;

import java.util.List;

import kr.or.kosta.leaf.common.db.DaoFactory;
import kr.or.kosta.leaf.common.web.Params;
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
	public List<Review> listByParams(Params params, int productCode){
		return reviewDao.listByParams(params, productCode);
	}
	
	@Override
	public int count(int productCode) {
		return reviewDao.count(productCode);
	}
	
	@Override
	public Review read(int reviewNo) {
		return reviewDao.read(reviewNo);
	}
	
	
	
}
