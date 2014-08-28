package JavaIO;

import java.io.*;
import java.util.Arrays;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class IO_Test_5_adapter_DataInput {
	public static void main(String[] args) throws IOException {
		writeToFile();
		readFromFile();
		
	}	
		
	
	private static void writeToFile() throws IOException {
		byte age = 45;
		String name = "Mike";
		int [] salaryArr = {200, 300, 250, 150};
		
		OutputStream outputStream =
				new GZIPOutputStream(
						new BufferedOutputStream(
								new FileOutputStream(
										new File ("data.bin"))));
		DataOutput dataOut = new DataOutputStream(outputStream);
		
		dataOut.writeByte(age);
		dataOut.writeUTF(name);
		dataOut.writeInt(salaryArr.length);
		for (int salaryElem:salaryArr){
			dataOut.writeInt(salaryElem);
		}
		
		outputStream.flush();
		outputStream.close();
	}
	private static void readFromFile() throws IOException {
				
		GZIPInputStream inputStream =
				new GZIPInputStream(
						new BufferedInputStream(
								new FileInputStream(
										new File ("data.bin"))));
		DataInput dataInput = new DataInputStream(inputStream);
		
		byte age = dataInput.readByte();
		String name = dataInput.readUTF();
		int[] salaryArr = new int[dataInput.readInt()];
		for (int k = 0; k<salaryArr.length;k++){
			salaryArr[k]=dataInput.readInt();
		}
		
		
		inputStream.close();
		System.out.println("age = "+age);
		System.out.println("name = "+name);
		System.out.println("salaryArr = "+Arrays.toString(salaryArr));
	}
		
}
	
