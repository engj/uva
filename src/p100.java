/**
 * Created by Justin on 2/7/14.
 */
import java.io.*;
import java.util.*;
public class p100 {
    private static int cycleLength(int a) {
        if (a == 1) {
            return a;
        }
        if (a % 2 != 0) {
            return 1 + cycleLength(3 * a + 1);
        }
        return 1 + cycleLength(a / 2);
    }
    private static int longestCycleLength(int a, int b) {
        int r = a;
        for (int i = a + 1; i <= b; i++) {
            if (cycleLength(i) > cycleLength(r)) {
                r = i;
            }
        }
        return cycleLength(r);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        while (in.hasNextLine()) {
            int a = in.nextInt();
            int b = in.nextInt();
            out.print(a);
            out.print(' ');
            out.print(b);
            out.print(' ');
            out.print(longestCycleLength(a, b));
            out.println();
            out.flush();
        }
    }
}
