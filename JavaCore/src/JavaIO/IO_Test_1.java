package JavaIO;

import java.io.*;
import java.net.URL;

public class IO_Test_1 {
	public static void main(String[] args) throws IOException {
		
		//чтение файла
		InputStream inFile = new FileInputStream("D:/Documents and Settings/RT/workspace/JavaCore/TestIO.txt");
		readFullyByByte(inFile);
		System.out.println("\n\n\n");
		
		/*//чтение URL
		InputStream inUrl = new URL("http://google.com").openStream();
		readFullyByByte(inUrl);
		System.out.println("\n\n\n");*/
		
		//Чтение байтов
		InputStream inArray = new ByteArrayInputStream(new byte[] {65,66,67,68});
		readFullyByByte(inArray);
		System.out.println("\n\n\n");
	}	
		
	public static void readFullyByByte(InputStream in) throws IOException{
		while (true){
			int oneByte = in.read();
			if (oneByte != -1){
				System.out.print((char) oneByte);
			} else {
				System.out.print("\n" + "end");
				break;
			}
		}
	
	}
		
}
