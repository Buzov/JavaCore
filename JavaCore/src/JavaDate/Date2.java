package JavaDate;

import java.util.Date;

//вычисление разницы между двумя текущими датами
public class Date2 {

	public static void main(String[] args) throws Exception
	{
		Date currentTime = new Date();
		Thread.sleep(3000);
		Date newTime = new Date();
		
		long msDelay = newTime.getTime() - currentTime.getTime();  
	    System.out.println("Time distance is: " + msDelay + " in ms");	

	}

}
