/**
 * Created by Justin on 2/9/14.
 */
import java.io.*;
import java.util.*;
public class p11559 {
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
    public static void main(String[] args) {
        String line;
        StringTokenizer st;
        while ((line = p11559.ReadLn(255)) != null && !line.equals("")) {
            st = new StringTokenizer(line);
            int n = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int mPrice = b;
            boolean mFound = false;
            for (int i = 0; i < h; i++) {
                line = p11559.ReadLn(255);
                st = new StringTokenizer(line);
                int p = Integer.parseInt(st.nextToken());
                line = p11559.ReadLn(255);
                st = new StringTokenizer(line);
                while (st.hasMoreTokens()) {
                    int numBeds = Integer.parseInt(st.nextToken());
                    if (numBeds < n) {
                        continue;
                    }
                    int tPrice = n * p;
                    if (tPrice <= mPrice) {
                        mPrice = tPrice;
                        mFound = true;
                    }
                }
            }
            if (mFound == false && mPrice == b) {
                System.out.println("stay home");
            } else {
                System.out.println(mPrice);
            }
        }
    }
}
