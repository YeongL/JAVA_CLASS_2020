public class EmpVO {
	private int empnum;
	private String ename;
	private String eauth;
	private String epw;
	public EmpVO() {
	}
	public EmpVO(int empnum, String ename, String eauth,String epw ) {
		this.empnum = empnum;
		this.eauth = eauth;
		this.ename = ename;
		this.epw = epw;
	}
	
	public int getENum() {
		return empnum;
	}
	
	public String getEAuth() {
		return eauth;
	}
	public String getEname() {
		return ename;
	}
	public String getEPW() {
		return epw;
	}
}

