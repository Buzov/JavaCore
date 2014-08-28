package JavaIO;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;



public class IO_Byte_Test_2 {
	public static void main (String [] args) throws IOException{
		String fileName = "TestIO.txt";
		
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
		
		byte[] buff = new byte[5];
	    //чтение файла кусками по 5 байт
		while (true){
				int count = in.read(buff);//возвращает количество прочитанных байтов
				if (count != -1){
					System.out.println("count = " + count
							+ ", buff = "+ Arrays.toString(buff)
							+ ", str = " + new String (buff, 0, count, "UTF8"));
				} else {
					break;
				}
		}
	}

}
