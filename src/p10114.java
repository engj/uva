/**
 * Created by Justin on 2/9/14.
 */
import java.io.*;
import java.util.*;
public class p10114 {
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
        while ((line = p10114.ReadLn(255)) != null) {
            st = new StringTokenizer(line);
            int months = Integer.parseInt(st.nextToken());
            if (months < 0) {
                break;
            }
            double downPayment = Double.parseDouble(st.nextToken());
            double initialValue = Double.parseDouble(st.nextToken()) + downPayment;
            int numRecords = Integer.parseInt(st.nextToken());
            double [] r = new double[months];
            for (int i = 0; i < numRecords; i++) {
                line = p10114.ReadLn(255);
                st = new StringTokenizer(line);
                int rIndex = Integer.parseInt(st.nextToken());
                double deprecation = Double.parseDouble(st.nextToken());
                r[rIndex] = deprecation;
            }
            double pDeprecation = r[0];
            for (int i = 1; i < r.length; i++) {
                if (r[i] == 0) {
                    r[i] = pDeprecation;
                }
                pDeprecation = r[i];
            }
            double cValue = initialValue;
            for (int i = 0; i < r.length; i++) {
                double owes = initialValue - (i * downPayment);
                cValue = cValue - (cValue * r[i]);
                if (owes < cValue) {
                    System.out.println((i - 1) + " months");
                    break;
                }
            }
        }
    }
}
