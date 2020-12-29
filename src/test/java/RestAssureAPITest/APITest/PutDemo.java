package RestAssureAPITest.APITest;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import java.util.HashMap;

import org.json.simple.JSONObject;
import org.junit.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.*;

public class PutDemo {
	
public static HashMap map = new HashMap();
	
	@BeforeClass
	public void testDate() {
		map.put("employee_name", RestTestUtil.getEmpName());
		map.put("employee_salary", RestTestUtil.getEmpSalary());
		map.put("employee_age", RestTestUtil.getEmpAge());
	
		
		RestAssured.baseURI = "https://dummy.restapiexample.com/api/v1";
		
		
	}
	
	@Test
	public static void updateEmployInfo() {
		int empId = 1;
		RestAssured.basePath = "/update/" + empId;
		
		Response responsevalue = 
		given()
			.contentType("application/json")
			.body(map)
		.when()
			.put()
		.then()
			.statusCode(200)
			.extract().response();
		
		String jsonR = responsevalue.asString();
		
		Assert.assertTrue(jsonR.contains("Successfully! Record has been updated."));

	}
	@Test (enabled = false)
	public static void deleteTest() {
		int empId = 22;
		RestAssured.basePath = "/delete/" + empId;
		given()
		.when()
			.delete()
		.then()
			.statusCode(200)
			.log().all();

	}
	
}
