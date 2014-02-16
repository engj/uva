/**
 * Created by Justin on 2/10/14.
 */
import java.io.*;
import java.util.*;
public class p11799 {
    public static void main(String args[] ) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int t = Integer.parseInt(in.readLine());
        for (int i = 1; i <= t; i++) {
            StringTokenizer line = new StringTokenizer(in.readLine());
            int n = Integer.parseInt(line.nextToken());
            int max = 0;
            while (line.hasMoreTokens()) {
                int s = Integer.parseInt(line.nextToken());
                if (s > max)
                    max = s;
            }
            System.out.println("Case " + i + ":" + " " + max);
        }

        in.close();
        out.close();
    }
}
