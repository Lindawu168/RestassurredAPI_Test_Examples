package RestAssureAPITest.APITest;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public class BasedConfig {

	
	public static Properties prop = new Properties();
	
	public static void main(String[] arg) {
		readProperties();
	}

	public static Properties readProperties() {
		
		try {
			FileInputStream fin = new FileInputStream("/Users/mac/eclipse-workspace/APITest_Demo/src/main/java/RestAssureAPITest/APITest/Common.properties");
			prop.load(fin);
			
		
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return prop;
	}
		public void writeProperties() {
			
			try {
				FileOutputStream fou = new FileOutputStream("/Users/mac/eclipse-workspace/APITest_Demo/src/main/java/RestAssureAPITest/APITest/Common.properties");
				prop.setProperty("result", "Pass");
				prop.store(fou, null);
			
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		
		
	}
}
