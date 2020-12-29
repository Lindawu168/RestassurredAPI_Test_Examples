package Post_Test_With_POJO_format;

public class Details {
	private String companyName;
	private String emailId;
	
	public Details(String companyName, String emailId) {
		this.companyName = companyName;
		this.emailId = emailId;
	}
	
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getemailId() {
		return emailId;
	}
	public void setemailId(String emailId) {
		this.emailId = emailId;
	}
	
	

}
