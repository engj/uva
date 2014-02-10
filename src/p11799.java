/**
 * Created by Justin on 2/10/14.
 */
import java.io.*;
import java.util.*;
public class p11799 {
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
        String line = null;
        StringTokenizer st = null;
        while ((line = p11799.ReadLn(255)) != null) {
            st = new StringTokenizer(line);
            int n = Integer.parseInt(st.nextToken());
            for (int i = 0; i < n; i++) {
                line = p11799.ReadLn(255);
                st = new StringTokenizer(line);
                int numScary = Integer.parseInt(st.nextToken());
                int mSpeed = 1;
                for (int j = 0; j < numScary; j++) {
                    int speed = Integer.parseInt(st.nextToken());
                    if (speed > mSpeed) {
                        mSpeed = speed;
                    }
                }
                System.out.println("Case " + (i + 1) + ": " + mSpeed);
            }
        }
    }
}
