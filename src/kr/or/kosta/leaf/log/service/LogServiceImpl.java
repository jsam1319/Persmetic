package kr.or.kosta.leaf.log.service;

import java.util.List;

import kr.or.kosta.leaf.common.db.DaoFactory;
import kr.or.kosta.leaf.log.dao.JdbcLogDao;
import kr.or.kosta.leaf.log.dao.LogDao;
import kr.or.kosta.leaf.log.domain.Log;

public class LogServiceImpl implements LogService {

	LogDao logDao = (LogDao)DaoFactory.getInstance().getDao(JdbcLogDao.class);
	
	@Override
	public List<Log> listLog(int ctmNo) {
		// TODO Auto-generated method stub
		return logDao.listLog(ctmNo);
	}

	@Override
	public void insertLog(Log log) {
		// TODO Auto-generated method stub
		logDao.insertLog(log);
	}

	
}
