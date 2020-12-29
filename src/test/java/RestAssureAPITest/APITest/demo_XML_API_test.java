package RestAssureAPITest.APITest;

import static io.restassured.RestAssured.*;
import static  org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

/*
 * 1) Verifying Single content in XML response
 * 2) Verifying Multiple content in XML response
 * 3) Verifying all the content in XML response in one go
 * 4) Find values using XML Path in XML response
 * 5) XPath with text() function
 */

public class demo_XML_API_test {
	
	
	@Test(priority = 1)
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

	
	
}
