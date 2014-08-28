package JavaIO;

import java.io.*;
import java.net.URL;

public class IO_Test_4_ReadAndOutputWrite_1 {
	public static void main(String[] args) throws IOException {
		
		//String fileName = "D:/Documents and Settings/RT/workspace/JavaCore/TestIO.txt";
		String fileFromName = "IO_Test_4_ReadAndOutputWrite.jpg";
		String fileToName = "IO_Test_4_ReadAndOutputWrite2.jpg";
		//чтение файла
		InputStream in = null;
		OutputStream out = null;
		
		try {
			in = new FileInputStream(fileFromName);
			out = new FileOutputStream(fileToName);
			long startTime = System.currentTimeMillis();
			copy(in, out);
			long stopTime = System.currentTimeMillis();
			System.out.println("Elapsed time = " + (stopTime-startTime));
		} catch (IOException e) {
		throw new IOException("Exception when open and read file"+fileFromName, e);
		}finally {
			closeQuietly(in);
			closeAndFlushQuietly(out);
			/*if(inFile != null){
				try {
					inFile.close();
				} catch (IOException ignore){
					
				}
			}*/
		}
		
		
		
	}	
		
	public static void copy(InputStream in, OutputStream out) throws IOException{
		
		
		byte [] buff = new byte[64*1024];
		int count;
		//читаем в буфер по пять байт
		while ((count = in.read(buff))!= -1){
				out.write(buff, 0, count);
				//System.out.print((char) oneByte);
		}
	}
	
	public static void closeQuietly(InputStream in){
		if (in != null){
			try{
				in.close();
			}catch (IOException ignore){
				//
			}
		}
	}
	
	public static void closeAndFlushQuietly(OutputStream out){
		if (out != null){
			try{
				out.flush();
			}catch (IOException ignore){/**/}
			try {
				out.close();
			}catch (IOException ignore){/**/}
		}
	}
	
}
	
