package JavaBufferedReader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class JavaSystemIn {
	public static void main(String[] args) throws Exception
    {
        BufferedReader red=new BufferedReader(new InputStreamReader(System.in));
        String name = red.readLine();
        String zarp = red.readLine();
        String year = red.readLine();
        int year2=Integer.parseInt(year);
        System.out.print(name+" получает "+zarp+" через "+year2+" лет");
        
       

    }
}
