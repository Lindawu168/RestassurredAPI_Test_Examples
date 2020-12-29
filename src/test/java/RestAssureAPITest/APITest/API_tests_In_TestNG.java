package RestAssureAPITest.APITest;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;


public class API_tests_In_TestNG {
	
	final static String url = "https://reqres.in/api/users?page=2";
	
	Response response = RestAssured.get(url);
	
	@Test(enabled = false)
	public void test() {
		
		
		//System.out.println(response.asString());
		//System.out.println(response.statusCode());
		
		System.out.println(response.getBody().asString());
		//System.out.println(response.statusLine());

		int statusCode = response.getStatusCode();
		assertEquals(statusCode, 200);
	}

	@Test(enabled = false)
	public void checkBody() {

		response.then().body("data.id[0]",equalTo(7));
	}

	@Test(enabled = false)
	public void verifyBodyHasValue() {
		response.then().assertThat().body("data.id[1]", equalTo(8))
		.body("data.first_name", hasItems("Lindsay","Rachel"))
		.log().body();
	}

	@Test
	
	public void theFirstPostTest() {
		JSONObject request = new JSONObject();
		request.put("name", "chaya");
		request.put("job", "BAA");

		System.out.println(request);
		System.out.println(request.toString());

		given().
		body(request.toJSONString()).
		when().
		put("https://reqres.in/api/users/2").
		then().statusCode(200);
		
		Response response = RestAssured.get("https://reqres.in/api/users/2");
		response.then().log().body();
	}
}
