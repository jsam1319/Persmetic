package kr.or.kosta.leaf.log.domain;

public class Log {

	int logNo;
	int ctmNo;
	LogType logType;
	String logDate;
	String logContent;
	
	public Log() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Log(int logNo, int ctmNo, LogType logType, String logDate, String logContent) {
		super();
		this.logNo = logNo;
		this.ctmNo = ctmNo;
		this.logType = logType;
		this.logDate = logDate;
		this.logContent = logContent;
	}



	public int getlogNo() {
		return logNo;
	}
	public int getCtmNo() {
		return ctmNo;
	}
	public LogType getLogType() {
		return logType;
	}
	public String getLogDate() {
		return logDate;
	}
	public String getLogContent() {
		return logContent;
	}
	public void setlogNo(int logNo) {
		this.logNo = logNo;
	}
	public void setCtmNo(int ctmNo) {
		this.ctmNo = ctmNo;
	}
	public void setLogType(LogType logType) {
		this.logType = logType;
	}
	public void setLogDate(String logDate) {
		this.logDate = logDate;
	}
	public void setLogContent(String logContent) {
		this.logContent = logContent;
	}
	
	
	
}
