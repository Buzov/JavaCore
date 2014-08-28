import java.util.Arrays;
import java.util.Scanner;
 //перестановки с повторением и без

public class Main {
 
    static int n, k;
    static int[] a;
 
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        k = in.nextInt();
        a = new int[k];
        System.out.println("Без повторений:");
        p1(0,0);
        System.out.println("С повторениями:");
        p2(0,1);
    }
 
    static void p1(int pos, int maxUsed) {
        if (pos == k) {
            System.out.println(Arrays.toString(a));
        } else {
            for(int i = maxUsed+1; i <= n; i++) {
                a[pos] = i;
                p1(pos+1,i);
            }
        }
    }
 
    static void p2(int pos, int maxUsed) {
        if(pos == k) {
            System.out.println(Arrays.toString(a));
        } else {
            for(int i = maxUsed; i <= n; i++) {
                a[pos] = i;
                p2(pos+1,i);
            }
        }
    }
}