package RestAssureAPITest.APITest;

import static io.restassured.RestAssured.*;
import static io.restassured.path.json.JsonPath.from;
import static  org.hamcrest.Matchers.*;

import java.util.List;

import org.testng.annotations.Test;

/*
 * 1) Test Status Code
 * 2) Log response
 * 3) Verify String content in response body
 * 4) Verify Multiple contents in response body
 * 5) Setting parameters and headers
 */

public class demo_api_testing {
	
	//@Test(priority=1, enabled = false)
	public void checkStatusCode() {
		when()
			.get("http://jsonplaceholder.typicode.com/posts/5")
		.then()
			.statusCode(200)
			.log().body();
	}
	
	//@Test(priority = 2)
	public void testLogs() {
		given()
		.when()
			.get("http://api.zippopotam.us/us/ma/belmont")
		.then()
			.statusCode(200)
			.log().body()
			.body("state", equalTo("Massachusetts"))
			.body("'state abbreviation'", equalTo("MA"))
			.body("'place name'", equalTo("Belmont"))
			.body("places[0].'place name'", equalTo("Belmont"))
			.body("'country abbreviation'", equalTo("US"));
		
	}

	//@Test(priority = 3)
	public void testMultipleValues() {
		given()
		.when()
			.get("http://api.zippopotam.us/us/ca/all")
		.then()
			.statusCode(200)
			.log().body()
			.body("'state abbreviation'", equalTo("CA"))
			.body("places.'place name'", hasItems("Moreno Valley", "Simi Valley", "Yucca Valley"))
			.body("'country abbreviation'", equalTo("US"));	
	}
	
	@Test
	public void testResponseList() {
		String returnResult = get("http://dummy.restapiexample.com/api/v1/employees").asString();
		List<String> ls = from(returnResult).getList("data.employee_name");
		
		int lsSize = ls.size();
		System.out.println(lsSize);
		for (String employee: ls) {
			if(employee.equals("Ashton Cox")) {
				System.out.println("My employee is found");
			}
		}
	}
	
}
