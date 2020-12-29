package RestAssureAPITest.APITest;

import org.apache.commons.lang3.RandomStringUtils;

public class RestTestUtil {
	public static String getFirstName() {
		String randomString = RandomStringUtils.randomAlphabetic(2);
		return ("John" + randomString );
	}

	public static String getLastName() {
		String randomString = RandomStringUtils.randomAlphabetic(2);
		return ("Kenndy" + randomString );
	}
	
	public static String getUserName() {
		String randomString = RandomStringUtils.randomAlphabetic(5);
		return ("John" + randomString );
	}
	
	public static String getPassword() {
		
		return ("Password1234!" );
	}
	
	public static String getEmail() {
		String randomString = RandomStringUtils.randomAlphabetic(5);
		return (randomString + "@gmail.com");
	}
	
	public static String getAvatarUrl(){
		return ("https://s3.amazonaws.com/uifaces/faces/twitter/calebogden/128.jpg");
	}
	
	public static String getEmpName() {
		String randomString = RandomStringUtils.randomAlphabetic(2);
		return ("Tiger " + randomString );
	}
	
	public static String getEmpSalary() {
		String randomString = RandomStringUtils.randomNumeric(6);
		return (randomString);
	}
	
	public static String getEmpAge() {
		String randomString = RandomStringUtils.randomNumeric(2);
		return (randomString);
	}
	
}
