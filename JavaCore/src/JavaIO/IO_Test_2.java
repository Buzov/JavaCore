package JavaIO;

import java.io.*;
import java.net.URL;

public class IO_Test_2 {
	public static void main(String[] args) throws IOException {
		
		String fileName = "D:/Documents and Settings/RT/workspace/JavaCore/TestIO.txt";
		//чтение файла
		InputStream inFile = null;
		try {
			inFile = new FileInputStream(fileName);
			readFullyByByte(inFile);
		} catch (IOException e) {
		throw new IOException("Exception when open and read file"+fileName);
		}finally {
			//closeQuietly(inFile);
			if(inFile != null){
				try {
					inFile.close();
				} catch (IOException ignore){
					
				}
			}
		}
		
		
		
	}	
		
	public static void readFullyByByte(InputStream in) throws IOException{
		
		int oneByte;
		//улучшеный код чтения(уменьшен в размере)
		while ((oneByte = in.read())!= -1){
				System.out.print((char) oneByte);
		}
	}
	
}
	
