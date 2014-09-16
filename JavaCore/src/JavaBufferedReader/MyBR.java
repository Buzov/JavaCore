package JavaBufferedReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;


public class MyBR {
	public static String sAge;
	public static String name;
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		Reader inputStreamReader = new InputStreamReader(inputStream);
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		
		try{
		name = bufferedReader.readLine();
		sAge = bufferedReader.readLine();
		}catch(IOException e){}
		
		int nAge = Integer.parseInt(sAge);
		System.out.print(""+name+nAge);
		

	}

}
