package JavaIO;

import java.io.*;
import java.net.URL;

public class IO_Test_4_Output {
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
			closeQuietly(inFile);
			/*if(inFile != null){
				try {
					inFile.close();
				} catch (IOException ignore){
					
				}
			}*/
		}
		
		
		
	}	
		
	public static byte[] readFullyByByte(InputStream in) throws IOException{
		
		
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		byte [] buff = new byte[5];
		int count;
		//читаем в буфер по пять байт
		while ((count = in.read(buff))!= -1){
				out.write(buff, 0, count);
				//System.out.print((char) oneByte);
		}
		return out.toByteArray();
	}
	
	public static void closeQuietly(InputStream inFile){
		if (inFile != null){
			try{
				inFile.close();
			}catch (IOException ignore){
				//
			}
		}
	}
	
}
	
