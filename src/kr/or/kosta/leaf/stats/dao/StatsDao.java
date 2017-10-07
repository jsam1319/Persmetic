package kr.or.kosta.leaf.stats.dao;

import java.util.List;

import kr.or.kosta.leaf.stats.domain.Stats;

public interface StatsDao {

	public List<Stats> getStatses(String startDate, String endDate);
}
