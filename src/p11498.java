/**
 * Created by Justin on 2/8/14.
 */
import java.io.*;
import java.util.*;
public class p11498 {
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
        }
        catch (IOException e) {
            return (null);
        }

        if ((car < 0) && (lg == 0)) {
            return (null);
        }
        return (new String (lin, 0, lg));
    }
    public static void main(String args[]) {
        String line;
        StringTokenizer lineTokens;
        int n, dx, dy, x, y;
        while ((line = p11498.ReadLn(255)) != null) {
            lineTokens = new StringTokenizer(line);
            n = Integer.parseInt(lineTokens.nextToken());
            if (n == 0) {
                break;
            }
            line = p11498.ReadLn(255);
            lineTokens = new StringTokenizer(line);
            dx = Integer.parseInt(lineTokens.nextToken());
            dy = Integer.parseInt(lineTokens.nextToken());
            for (int i = 0; i < n; i++) {
                line = p11498.ReadLn(255);
                lineTokens = new StringTokenizer(line);
                x = Integer.parseInt(lineTokens.nextToken());
                y = Integer.parseInt(lineTokens.nextToken());
                if (x == dx || y == dy) {
                    System.out.println("divisa");
                } else if (x > dx && y > dy) {
                    System.out.println("NE");
                } else if (x > dx && y < dy) {
                    System.out.println("SE");
                } else if (x < dx && y < dy) {
                    System.out.println("SO");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }
}
