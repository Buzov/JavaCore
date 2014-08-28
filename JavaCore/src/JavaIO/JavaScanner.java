package JavaIO;

import java.util.Scanner;

public class JavaScanner
{
    public static void main(String[] args) throws Exception
    {
    	Scanner scanner=new Scanner(System.in);
        String name=scanner.nextLine();
        int year=scanner.nextInt();
        //int a = Integer.parseInt(year);
        System.out.print(name+" захватит мир через " +year+" лет. Му-ха-ха!");

    }
}
