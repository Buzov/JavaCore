package JavaIO;

import java.io.ByteArrayInputStream;

//поточ читает байты, но выдает инты

public class IO_Byte_Test_1 {
	public static void main (String [] args){
		byte[] array = {
				-128, -127, -126, -3, -2, 
				0,
				1, 2, 3, 125, 126, 127
		};
		for (byte byteValue : array){
			int intValue = new ByteArrayInputStream(new byte[]{byteValue}).read();
			System.out.println("byte ("+byteValue+") -> int )"+ intValue);		
		}
	}

}
