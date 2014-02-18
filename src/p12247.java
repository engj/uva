import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by Justin on 2/16/14.
 */
public class p12247 {
    private static String arrayString(int[] a) {
        String r = "{ ";
        for (int i = 0; i < a.length; i++)
            r += a[i] + " ";
        return r + "}";
    }
    private static boolean doCheck(int[] a, int[] b) {
        ArrayList<int[]> pl = new ArrayList<int[]>();
        permute(b, b.length, pl);
        for (int i = 0; i < pl.size(); i++) {
            int[] c = pl.get(i);
            //System.out.println(arrayString(a) + "vs" + arrayString(c));
            if (!won(a, c))
                return false;
        }
        return true;
    }
    /* This was needed. Otherwise, it would be:
       { 28 51 29 }vs{ 50 52 1 }
       { 28 51 29 }vs{ 50 52 1 }
       { 28 51 29 }vs{ 50 52 1 }
       { 28 51 29 }vs{ 50 52 1 }
       { 28 51 29 }vs{ 50 52 1 }
       { 28 51 29 }vs{ 50 52 1 }
     */
    private static int[] copyArray(int[] a) {
        int[] r = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            r[i] = a[i];
        }
        return r;
    }
    private static void permute(int[] a, int n, ArrayList<int[]> pl) {
        if (n == 1) {
            //System.out.println(arrayString(a));
            pl.add(copyArray(a));
            return;
        }
        for (int i = 0; i < n; i++) {
            swap(a, i, n - 1);
            permute(a, n - 1, pl);
            swap(a, i, n - 1);
        }
    }
    private static int[] swap(int[] a, int b, int c) {
        int t = a[b];
        a[b] = a[c];
        a[c] = t;
        return a;
    }
    private static int[] insertionSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int t = a[i];
            int j;
            for (j = i - 1; j >= 0; j--) {
                if (a[j] > t)
                    a[j + 1] = a[j];
                else
                    break;
            }
            a[j + 1] = t;
        }
        return a;
    }
    private static int pickUnusedCard(int[] takenCrds, int[] crds, int numWins) {
        crds = insertionSort(crds);
        int crd;
        for (crd = 1; crd <= 52; crd++)
            if (takenCrds[crd - 1] != 1)
                if (numWins == 0)
                    break;
                else if (numWins == 1 && crd > crds[0])
                    break;
                else if (numWins == 2 && crd > crds[1])
                    break;
                else if (numWins == 3 && crd > crds[2])
                    break;
        return crd;
    }
    private static boolean won(int[] a, int[] b) {
        int w = 0;
        for (int i = 0; i < 3; i++)
            if (b[i] >= a[i])
                w++;
        if (w >= 2)
            return true;
        return false;
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

            int[] sister = new int[3];
            int[] prince = new int[3];

            sister[0] = crds[0]; sister[1] = crds[1]; sister[2] = crds[2];
            prince[0] = crds[3]; prince[1] = crds[4];

            boolean foundSolution = false;
            for (int i = 0; i < 4; i++) {
                prince[2] = pickUnusedCard(crdsTaken, sister, i);
                //System.out.println(prince[2]);
                if (doCheck(sister, prince)) {
                    foundSolution = true;
                    break;
                }
            }

            if (foundSolution == true && prince[2] != 53) {
                System.out.println(prince[2]);
            } else {
                System.out.println("-1");
            }

        }
        in.close();
        out.close();
    }
}
