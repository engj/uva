/**
 * Created by Justin on 2/8/14.
 */
import java.io.*;
import java.util.*;

class Main
{
    static String ReadLn (int maxLg)  // utility function to read from stdin
    {
        byte lin[] = new byte [maxLg];
        int lg = 0, car = -1;
        String line = "";

        try
        {
            while (lg < maxLg)
            {
                car = System.in.read();
                if ((car < 0) || (car == '\n')) break;
                lin [lg++] += car;
            }
        }
        catch (IOException e)
        {
            return (null);
        }

        if ((car < 0) && (lg == 0)) return (null);  // eof
        return (new String (lin, 0, lg));
    }

    public static void main (String args[]) {
        String line;
        StringTokenizer lineTokens;
        int a, b;
        line = Main.ReadLn(255);
        while ((line = Main.ReadLn(255)) != null) {
            lineTokens = new StringTokenizer(line);
            a = Integer.parseInt(lineTokens.nextToken());
            b = Integer.parseInt(lineTokens.nextToken());
            if (a == b) {
                System.out.println("=");
            } else if (a > b) {
                System.out.println(">");
            } else {
                System.out.println("<");
            }
        }
    }
}
