import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;
public class Combinations {
    public static void main(String[] args) throws IOException {
        String[] tokens = readTokens();
        System.out.println("Tokens: " + Arrays.toString(tokens));
        System.out.println("Combinations:");
        for (int i = 0; i < tokens.length; i++) {
            for (int j = i; j < tokens.length; j++) {
                String combination = "{" + tokens[i] + " , " + tokens[j] + "}";
                System.out.println("  " + combination);
            }
        }
    }
    private static String[] readTokens() throws IOException {
        Set<String> result = new TreeSet<String>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String t;
        while (true) {
            System.out.print("Enter token or blank line to end input: ");
            t = reader.readLine();
            if (t == null || (t = t.trim()).isEmpty()) {
                break;
            }
            result.add(t);
        }
        return result.toArray(new String[result.size()]);
    }
}