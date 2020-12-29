package Post_Test_With_POJO_format;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertFalse;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import RestAssureAPITest.APITest.BasedConfig;
import io.restassured.response.Response;


public class PostAPIUsingPojo{
	

	public static String BasedUrl;
	@BeforeClass
	public void setUp(){
		BasedUrl = BasedConfig.readProperties().getProperty("Based_Url");
	}
	
	
	EmployeeInfo employInfo = new EmployeeInfo("Linda", "Tester", new String[] {"Java", "#C"}, "OLG", "linda@olg.ca");
	@Test
	public void postANewUserTest(){
		
		
		Response rp = 
		given()
			.auth().none()
			.body(employInfo)
		.when()
			.post(BasedUrl + "/users")
			//.post("https://reqres.in/api/users")
		.then()
			.statusCode(201)
			.extract().response();
		
		System.out.println(rp.jsonPath().get("id"));
		
		assertFalse(rp.jsonPath().get("id").equals(null));
		System.out.println(BasedUrl);
		
	}
	

}
