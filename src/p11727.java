/**
 * Created by Justin on 2/8/14.
 */
import java.io.*;
import java.util.*;
public class p11727 {
    static String ReadLn (int maxLg) {
        byte lin[] = new byte [maxLg];
        int lg = 0, car = -1;
        String line = "";

        try {
            while (lg < maxLg) {
                car = System.in.read();
                if ((car < 0) || (car == '\n')) break;
                lin [lg++] += car;
            }
        } catch (IOException e) {
            return (null);
        }

        if ((car < 0) && (lg == 0)) {
            return (null);
        }
        return (new String (lin, 0, lg));
    }
    private static int[] insertionSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int n = a[i];
            int j;
            for (j = i; j > 0; j--) {
                if (n > a[j - 1]) {
                    a[j] = a[j - 1];
                } else {
                    break;
                }
            }
            a[j] = n;
        }
        return a;
    }
    public static void main(String args[]) {
        String line = p11727.ReadLn(255);
        StringTokenizer lineTokens = new StringTokenizer(line);
        int n = Integer.parseInt(lineTokens.nextToken());
        int[] salaries = new int[3];
        for (int i = 0; i < n; i++) {
            line = p11727.ReadLn(255);
            lineTokens = new StringTokenizer(line);
            for (int k = 0; k < 3; k++) {
                int salary = Integer.parseInt(lineTokens.nextToken());
                salaries[k] = salary;
            }
            salaries = insertionSort(salaries);
            System.out.println("Case " + (i + 1) + ": " + salaries[1]);
        }
    }
}
