package kr.or.kosta.leaf.log.service;

import java.util.List;

import kr.or.kosta.leaf.log.domain.Log;

public interface LogService {
	
	public List<Log> listLog(int ctmNo);
	
	public void insertLog(Log log);
}
