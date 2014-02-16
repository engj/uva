/**
 * Created by Justin on 2/10/14.
 */
import java.io.*;
import java.util.*;
public class p11799 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int t = in.nextInt();
        for (int i = 1; i <= t; i++) {
            int n = in.nextInt();
            int max = 0;
            for (int j = 0; j < n; j++) {
                int s = in.nextInt();
                if (s > max)
                    max = s;
            }
            out.println("Case " + i + ":" + " " + max);
        }
        in.close();
        out.close();
    }
}
