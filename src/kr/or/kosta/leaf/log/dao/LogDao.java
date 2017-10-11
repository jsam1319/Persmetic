package kr.or.kosta.leaf.log.dao;

import java.util.List;

import kr.or.kosta.leaf.log.domain.Log;

public interface LogDao {

	public List<Log> listLog(int ctmNo);
	
	public void insertLog(Log log);
}
