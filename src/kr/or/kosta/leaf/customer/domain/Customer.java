package kr.or.kosta.leaf.customer.domain;

public class Customer {

	private int ctmNo;
	private String ctmName;
	private String ctmDivision;
	private String ctmId;
	private String ctmPasswd;
	private String ctmRegdate;
	private int ctmAge;
	private String ctmGender;
	private String ctmAddress;
	private String ctmTone;
	private String ctmJob;
	private String ctmEmail;
	private String ctmSnsid;

	public Customer() {
	}

	public Customer(int ctmNo, String ctmName, String ctmDivision, String ctmId, String ctmPasswd, String ctmRegdate,
			int ctmAge, String ctmGender, String ctmAddress, String ctmTone, String ctmJob, String ctmEmail, String ctmSnsid) {
		this.ctmNo = ctmNo;
		this.ctmName = ctmName;
		this.ctmDivision = ctmDivision;
		this.ctmId = ctmId;
		this.ctmPasswd = ctmPasswd;
		this.ctmRegdate = ctmRegdate;
		this.ctmAge = ctmAge;
		this.ctmGender = ctmGender;
		this.ctmAddress = ctmAddress;
		this.ctmTone = ctmTone;
		this.ctmJob = ctmJob;
		this.ctmEmail = ctmEmail;
		this.ctmSnsid = ctmSnsid;
	}

	
	public int getCtmNo() {
		return ctmNo;
	}

	public String getCtmName() {
		return ctmName;
	}

	public String getCtmDivision() {
		return ctmDivision;
	}

	public String getCtmId() {
		return ctmId;
	}

	public String getCtmPasswd() {
		return ctmPasswd;
	}

	public String getCtmRegdate() {
		return ctmRegdate;
	}

	public int getCtmAge() {
		return ctmAge;
	}

	public String getCtmGender() {
		return ctmGender;
	}

	public String getCtmAddress() {
		return ctmAddress;
	}

	public String getCtmTone() {
		return ctmTone;
	}

	public String getCtmJob() {
		return ctmJob;
	}

	public String getCtmEmail() {
		return ctmEmail;
	}

	public String getCtmSnsid() {
		return ctmSnsid;
	}

	public void setCtmNo(int ctmNo) {
		this.ctmNo = ctmNo;
	}

	public void setCtmName(String ctmName) {
		this.ctmName = ctmName;
	}

	public void setCtmDivision(String ctmDivision) {
		this.ctmDivision = ctmDivision;
	}

	public void setCtmId(String ctmId) {
		this.ctmId = ctmId;
	}

	public void setCtmPasswd(String ctmPasswd) {
		this.ctmPasswd = ctmPasswd;
	}

	public void setCtmRegdate(String ctmRegdate) {
		this.ctmRegdate = ctmRegdate;
	}

	public void setCtmAge(int ctmAge) {
		this.ctmAge = ctmAge;
	}

	public void setCtmGender(String ctmGender) {
		this.ctmGender = ctmGender;
	}

	public void setCtmAddress(String ctmAddress) {
		this.ctmAddress = ctmAddress;
	}

	public void setCtmTone(String ctmTone) {
		this.ctmTone = ctmTone;
	}

	public void setCtmJob(String ctmJob) {
		this.ctmJob = ctmJob;
	}

	public void setCtmEmail(String ctmEmail) {
		this.ctmEmail = ctmEmail;
	}

	public void setCtmSnsid(String ctmSnsid) {
		this.ctmSnsid = ctmSnsid;
	}

	@Override
	public String toString() {
		return "Customer [ctmNo=" + ctmNo + ", ctmName=" + ctmName + ", ctmDivision=" + ctmDivision + ", ctmId=" + ctmId
				+ ", ctmPasswd=" + ctmPasswd + ", ctmRegdate=" + ctmRegdate + ", ctmAge=" + ctmAge + ", ctmGender="
				+ ctmGender + ", ctmAddress=" + ctmAddress + ", ctmTone=" + ctmTone + ", ctmJob=" + ctmJob
				+ ", ctmEmail=" + ctmEmail + ", ctmSnsid=" + ctmSnsid + "]";
	}

	

	
	
	
}
