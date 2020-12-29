package Post_Test_With_POJO_format;

public class EmployeeInfo {
	private String userName;
	private String job;
	private String[] skills;
	private Details details;
	
	public EmployeeInfo (String userName, String job, String[] skills, String companyName, String emailId) {
		this.userName = userName;
		this.job = job;
		this.skills = skills;
		this.details = new Details(companyName, emailId);
	}
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String[] getSkills() {
		return skills;
	}
	public void setSkills(String[] skills) {
		this.skills = skills;
	}
	
	

}
