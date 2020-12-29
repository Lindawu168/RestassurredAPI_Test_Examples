package Serialization_Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
class OutputTest implements Serializable{
	int i=1;
	int j=10;
}

public class SerializationTest {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
	
		
		// 1. Serialization Test
		OutputTest otp = new OutputTest();
		FileOutputStream fop = new FileOutputStream("serialization.txt");
		ObjectOutputStream oop = new ObjectOutputStream(fop);
		oop.writeObject(otp);
		
		//2. Deserialization Test
		
		FileInputStream fip = new FileInputStream("serialization.txt");
		ObjectInputStream oip = new ObjectInputStream(fip);
		
		OutputTest t2 = (OutputTest) oip.readObject();
		System.out.println(t2.i + " " + t2.j);

	}

}
