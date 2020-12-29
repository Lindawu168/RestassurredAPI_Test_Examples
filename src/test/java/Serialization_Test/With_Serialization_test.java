package Serialization_Test;

import java.util.ArrayList;
import java.util.HashMap;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import junit.framework.Assert;

public class With_Serialization_test {
	
	
	
	
	@Test(priority=1)
	public void withSerializationTest() {
		
		ArrayList<String> coursesList = new ArrayList<String>();
		coursesList.add("Java");
		coursesList.add("Selenium");
		
		StudentInfo stu = new StudentInfo();
		stu.setId(101);
		stu.setName("Kenndy");
		stu.setEmail("Testia@gmail.com");
		stu.setCourses(coursesList);
		
		
		given()
			.contentType(ContentType.JSON)
			.body(stu)
		.when()
			.post("https://localHost:8085/student")
		.then()
			.statusCode(201);
			
	}
	
	@Test(priority = 2)
	///Get new student info - DeSerializaton
	public void getStudentInfo() {
		StudentInfo stu = get("https://localHost:8085/student").as(StudentInfo.class);
		System.out.println(stu.getStudentRecord());
		
		System.out.println(stu.getId());
	}
	
	
}

