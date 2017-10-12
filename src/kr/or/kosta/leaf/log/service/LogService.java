package kr.or.kosta.leaf.log.service;

import java.util.List;

import kr.or.kosta.leaf.log.domain.Log;
import kr.or.kosta.leaf.log.domain.LogType;

public interface LogService {
	
	public List<Log> listLog(int ctmNo);
	
	public void insertLog(Log log);
}
