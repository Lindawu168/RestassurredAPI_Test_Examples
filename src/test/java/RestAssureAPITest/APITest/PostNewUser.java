package RestAssureAPITest.APITest;

import io.restassured.RestAssured;

import io.restassured.response.Response;

import static org.testng.Assert.assertEquals;

import java.util.HashMap;

import org.json.simple.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class PostNewUser {
	
	final static String url = "https://reqres.in/api/users?page=2";
	public static HashMap map = new HashMap();
	
	@BeforeClass
	public void testDate() {
		map.put("email", RestTestUtil.getEmail());
		map.put("first_name", RestTestUtil.getFirstName());
		map.put("last_name", RestTestUtil.getLastName());
		map.put("avatar", RestTestUtil.getAvatarUrl());
		
		RestAssured.baseURI = "https://reqres.in/api/user";
		RestAssured.basePath = "/register";
		
	}
	
	@Test
	public void postTest() {
		given()
			.contentType("application/json")
			.body(map)
		
		.when()
			.post()
		
		.then()
			.statusCode(201)
			.and()
			.body("last_name", containsString("Kenndy"));
	}
	

}
