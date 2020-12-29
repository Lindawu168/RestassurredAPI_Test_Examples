package RestAssureAPITest.APITest;

import org.testng.annotations.Test;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static  org.hamcrest.Matchers.*;

public class GetCityWeatherTest {
	final static String url="http://api.openweathermap.org/data/2.5/weather";

/*
 * given(): set cookies, add auth, add param, set headers
 * when():  get, put, post, patch, delete
 * then(): validate status code; extract response, extract header, cookies & response body
 */
	@Test
	public void getCityWeather() {
		given()
				.queryParam("q", "London, uk")
				.queryParam("appid", "9de243494c0b295cca9337e1e96b00e2")
		.when()
				.get(url)
		.then()
				.statusCode(200)
				.statusLine("HTTP/1.1 200 OK")
				.header("Content-Type", containsString("application/json"))
				.body("name", equalTo("London"))
				.log().all();
	}
}
