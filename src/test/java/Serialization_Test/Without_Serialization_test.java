package Serialization_Test;

import java.util.ArrayList;
import java.util.HashMap;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import RestAssureAPITest.APITest.BasedConfig;

public class Without_Serialization_test extends BasedConfig{
	
	
	
	/*
	 * Payload body:
	 * {
	 * 		"id": 101,
	 * 		"name": "Kenndy",
	 * 		"email": "kennday@gmail.com",
	 * 		"courses" : [
	 * 			"java",
	 * 			"Selenium"
	 * 			]
	 * }
	 */

	// using map to store info
	public HashMap map = new HashMap();
	
	@Test(priority=1)
	public void withoutSerializationTest() {
		map.put("id", 101);
		map.put("name", "Kenndy");
		map.put("email", "kennday@gmail.com");
		
		ArrayList<String> coursesList = new ArrayList<String>();
		coursesList.add("java");
		coursesList.add("Selenium");
		
		map.put("courses", coursesList);
		
		given()
			.body(map)
		.when()
			.post("http://localhost:8085/student")
		.then()
			.statusCode(201)
			.assertThat()
			.body("msg", equalTo("Student added"));
			
	}
	
	@Test(priority = 2)
	//Get new student info
	public void getStudentInfo() {
		given()

		.when()
			.get("http://localhost:8085/student/101")
		.then()
			.statusCode(200)
			.assertThat()
			.body("id", equalTo(101))
			.body("name", equalTo("Kenndy"))
			.log().body();
	}
	//Using Serialization /De-serialization
	@Test(priority =3)
	public void usingSerialization() {
		
	}
	
}

