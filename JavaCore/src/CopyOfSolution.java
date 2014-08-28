import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CopyOfSolution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader der=new BufferedReader(new InputStreamReader(System.in));
        String name=der.readLine();
        String year=der.readLine();
        int a = Integer.parseInt(year);
        System.out.print(name+" захватит мир через " +a+" лет. Му-ха-ха!");

    }
}
