package RestAssureAPITest.APITest;

import io.restassured.RestAssured;
import io.restassured.http.Headers;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import io.restassured.specification.RequestSpecification;
import java.util.concurrent.TimeUnit;

/**
 * Unit test for simple App.
 */
public class MyFirstRestAssuredClass{
	
	final static String url = Util.BASE_URL + "V4/sinkministatement.php?CUSTOMER_ID=" + Util.CUSTOMER_ID + "&PASSWORD=" + Util.PASSWORD + "Account_No=" + Util.ACCOUNT_NO + "\"";

	//"http://demo.guru99.com/V4/sinkministatement.php?CUSTOMER_ID=68195&PASSWORD=1234!&Account_No=1";
	
	public static void main(String args[]) {
		getResponseBody();
		getResponseStatus();
		getResponseHeaders();
		getResponseTime();
		getResponseContentType();
		//getSpecificPartOfResponseBody();
		
	}
	public static void getResponseBody(){
		RestAssured.given().queryParam("CUSTOMER_ID",Util.CUSTOMER_ID)
        .queryParam("PASSWORD",Util.PASSWORD)
        .queryParam("Account_No",Util.ACCOUNT_NO)
        .when().get(Util.BASE_URL + "V4/sinkministatement.php").then().log()
        .body();
		}
	
	public static void getResponseStatus(){
		int statusCode = RestAssured.given().queryParam("CUSTOMER_ID",Util.CUSTOMER_ID)
        .queryParam("PASSWORD",Util.PASSWORD)
        .queryParam("Account_No",Util.ACCOUNT_NO)
        .when().get(url).getStatusCode();
		
		System.out.println("The response statue is " + statusCode);
		RestAssured.given().when().get(url).then().assertThat().statusCode(200);
		}
	public static void getResponseHeaders() {
		 
		Headers headers = get(url).then().extract().headers();
		System.out.println("The headers in the response are " + headers);
		System.out.println("The header type in the response is " + headers.get("Content-Type"));
		
	}
	public static void getResponseTime(){
		  System.out.println("The time taken to fetch the response "+ get(url).timeIn(TimeUnit.MILLISECONDS) + " milliseconds");
		}
	public static void getResponseContentType(){
		   System.out.println("The content type of response " + get(url).then().extract().contentType());
		}
	
	public static void getSpecificPartOfResponseBody(){

		ArrayList<String> amounts = when().get(url).then().extract().path("'result:'.statements.AMOUNT") ;
		int sumOfAll=0;
		for(String a:amounts){

		    System.out.println("The amount value fetched is "+a);
		    sumOfAll=sumOfAll+Integer.valueOf(a);
		}
		System.out.println("The total amount is "+sumOfAll);

		}
	
	//// Get info from https://dummy.restapiexample.com/api/v1/employees
	
	

}
