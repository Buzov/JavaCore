package EPAM;

public class My2 {
	public static void main(String[] args) {
		int i = 0;
		int j = 9;
		do{
			if(i>j--) {break;};
		}while(i++<5);
		System.out.print(i+" "+j);	

	}
}
