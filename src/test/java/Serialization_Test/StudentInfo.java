package Serialization_Test;

import java.util.List;

public class StudentInfo {
	
	public Integer id;
	public String name;
	public String email;
	List<String> courses;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<String> getCourses() {
		return courses;
	}
	public void setCourses(List<String> courses) {
		this.courses = courses;
	}
	
	public String getStudentRecord() {
		return (this.id + " " + this.name + " " + this.email + " " + this.courses);
	}

}
