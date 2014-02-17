import java.io.*;
import java.util.*;
/**
 * Created by Justin on 2/10/14.
 */
public class p10141 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int prop = 1;
        while (true) {
            StringTokenizer line = new StringTokenizer(in.readLine());
            int nR = Integer.parseInt(line.nextToken());
            int nP = Integer.parseInt(line.nextToken());
            String bC = "";
            double bP = Double.MAX_VALUE;
            int bR = 0;

            // For problems with no defined number of input lines, the following snippet is not needed
            // if (line == null || line.equals(""))
            //    break;

            if (nR == 0 && nP == 0)
                break;

            for (int i = 0; i < nR; i++)
                in.readLine();

            for (int i = 0; i < nP; i++) {
                String c = in.readLine();
                line = new StringTokenizer(in.readLine());
                double p = Double.parseDouble(line.nextToken());
                int r = Integer.parseInt(line.nextToken());

                if (r > bR || (r == bR && p < bP)) {
                    bC = c;
                    bP = p;
                    bR = r;
                }

                for (int j = 0; j < r; j++)
                    in.readLine();
            }

            // Omitting this condition resulted in a WA
            if (prop != 1)
                out.println();
            out.println("RFP #" + prop);
            out.println(bC);

            prop++;
        }


        in.close();
        out.close();
    }
}
