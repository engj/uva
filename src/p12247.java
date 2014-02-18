import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * Created by Justin on 2/16/14.
 */
public class p12247 {
    private static int numWins(int[] a, int b) {
        int n = 0;
        for (int i = 0; i < 3; i++)
            if (b > a[i])
                n++;
        return n;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        while (true) {
            StringTokenizer line = new StringTokenizer(in.readLine());
            int[] crds = new int[5];
            int[] crdsTaken = new int[52];
            int numZeros = 0;
            for (int i = 0; i < 5; i++) {
                int crd = Integer.parseInt(line.nextToken());
                crds[i] = crd;
                if (crd != 0)
                    crdsTaken[crd - 1] = 1;
                if (crds[i] == 0)
                    numZeros++;
            }

            if (numZeros == 5)
                break;

            int numWinsA = numWins(crds, crds[3]);
            int numWinsB = numWins(crds, crds[4]);

            if ((numWinsA < 2 || numWinsB < 2) && !(numWinsA == 3 || numWinsB == 3)) {
                System.out.println("-1");
                continue;
            }

            int minAmt = 2;
            if ((numWinsA < 2 || numWinsB < 2) && (numWinsA == 3 || numWinsB == 3))
                minAmt = 3;
            if (numWinsA == 3 && numWinsB == 3)
                minAmt = 0;

            int r = -1;
            for (int i = 0; i < 52; i++)
                if (crdsTaken[i] != 1 && numWins(crds, i + 1) >= minAmt) {
                    r = i + 1;
                    break;
                }
            System.out.println(r);
        }
        in.close();
        out.close();
    }
}
