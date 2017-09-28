package kr.or.kosta.leaf.customer.domain;

public class Customer {

	private int ctm_no;
	private String ctm_name;
	private String ctm_division;
	private String ctm_id;
	private String ctm_passwd;
	private String ctm_regdate;
	private int ctm_age;
	private String ctm_gender;
	private String ctm_address;
	private String ctm_tone;
	private String ctm_job;
	private String ctm_email;

	public Customer() {
	}

	public Customer(int ctm_no, String ctm_name, String ctm_division, String ctm_id, String ctm_passwd, String ctm_regdate,
			int ctm_age, String ctm_gender, String ctm_address, String ctm_tone, String ctm_job, String ctm_email) {
		this.ctm_no = ctm_no;
		this.ctm_name = ctm_name;
		this.ctm_division = ctm_division;
		this.ctm_id = ctm_id;
		this.ctm_passwd = ctm_passwd;
		this.ctm_regdate = ctm_regdate;
		this.ctm_age = ctm_age;
		this.ctm_gender = ctm_gender;
		this.ctm_address = ctm_address;
		this.ctm_tone = ctm_tone;
		this.ctm_job = ctm_job;
		this.ctm_email = ctm_email;
	}

	public int getCtm_no() {
		return ctm_no;
	}

	public void setCtm_no(int ctm_no) {
		this.ctm_no = ctm_no;
	}

	public String getCtm_name() {
		return ctm_name;
	}

	public void setCtm_name(String ctm_name) {
		this.ctm_name = ctm_name;
	}

	public String getCtm_division() {
		return ctm_division;
	}

	public void setCtm_division(String ctm_division) {
		this.ctm_division = ctm_division;
	}

	public String getCtm_id() {
		return ctm_id;
	}

	public void setCtm_id(String ctm_id) {
		this.ctm_id = ctm_id;
	}

	public String getCtm_passwd() {
		return ctm_passwd;
	}

	public void setCtm_passwd(String ctm_passwd) {
		this.ctm_passwd = ctm_passwd;
	}

	public String getCtm_regdate() {
		return ctm_regdate;
	}

	public void setCtm_regdate(String ctm_regdate) {
		this.ctm_regdate = ctm_regdate;
	}

	public int getCtm_age() {
		return ctm_age;
	}

	public void setCtm_age(int ctm_age) {
		this.ctm_age = ctm_age;
	}

	public String getCtm_gender() {
		return ctm_gender;
	}

	public void setCtm_gender(String ctm_gender) {
		this.ctm_gender = ctm_gender;
	}

	public String getCtm_address() {
		return ctm_address;
	}

	public void setCtm_address(String ctm_address) {
		this.ctm_address = ctm_address;
	}

	public String getCtm_tone() {
		return ctm_tone;
	}

	public void setCtm_tone(String ctm_tone) {
		this.ctm_tone = ctm_tone;
	}

	public String getCtm_job() {
		return ctm_job;
	}

	public void setCtm_job(String ctm_job) {
		this.ctm_job = ctm_job;
	}

	public String getCtm_email() {
		return ctm_email;
	}

	public void setCtm_email(String ctm_email) {
		this.ctm_email = ctm_email;
	}

	@Override
	public String toString() {
		return "Customer [ctm_no=" + ctm_no + ", ctm_name=" + ctm_name + ", ctm_division=" + ctm_division + ", ctm_id="
				+ ctm_id + ", ctm_passwd=" + ctm_passwd + ", ctm_regdate=" + ctm_regdate + ", ctm_age=" + ctm_age
				+ ", ctm_gender=" + ctm_gender + ", ctm_address=" + ctm_address + ", ctm_tone=" + ctm_tone
				+ ", ctm_job=" + ctm_job + ", ctm_email=" + ctm_email + "]";
	}

	
}
