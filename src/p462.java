import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by Justin on 2/15/14.
 */
public class p462 {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Solver solver = new Solver();
        solver.solve(in, out);
    }

    private static class Solver {
        public void solve(InputReader in, PrintWriter out) {
            while(true) {
                String line;
                try {
                    line = in.reader.readLine().trim();
                } catch (IOException e) {
                    break;
                }

                StringTokenizer st = new StringTokenizer(line);

                int[][] h = new int[4][13];
                int p = 0;
                boolean[] stp = new boolean[4];
                boolean allStp = true;
                char[] su = new char[4];
                su[0] = 'S'; su[1] = 'H'; su[2] = 'D'; su[3] = 'C';
                char bstBd = '0';
                int mstCrds = 0;

                while (st.hasMoreTokens()) {
                    String c = st.nextToken();
                    char r = c.charAt(0);
                    char s = c.charAt(1);

                    if (r == 'A') {
                        p += 4;
                        if (s == 'S') h[0][0] = 1;
                        else if (s == 'H') h[1][0] = 1;
                        else if (s == 'D') h[2][0] = 1;
                        else if (s == 'C') h[3][0] = 1;
                    } else if (r == 'J') {
                        p += 1;
                        if (s == 'S') h[0][10] = 1;
                        else if (s == 'H') h[1][10] = 1;
                        else if (s == 'D') h[2][10] = 1;
                        else if (s == 'C') h[3][10] = 1;
                    } else if (r == 'Q') {
                        p += 2;
                        if (s == 'S') h[0][11] = 1;
                        else if (s == 'H') h[1][11] = 1;
                        else if (s == 'D') h[2][11] = 1;
                        else if (s == 'C') h[3][11] = 1;
                    } else if (r == 'K') {
                        p += 3;
                        if (s == 'S') h[0][12] = 1;
                        else if (s == 'H') h[1][12] = 1;
                        else if (s == 'D') h[2][12] = 1;
                        else if (s == 'C') h[3][12] = 1;
                    } else if (r == 'T') {
                        if (s == 'S') h[0][9] = 1;
                        else if (s == 'H') h[1][9] = 1;
                        else if (s == 'D') h[2][9] = 1;
                        else if (s == 'C') h[3][9] = 1;
                    } else {
                        int cN = Character.getNumericValue(r) - 1;
                        if (s == 'S') h[0][cN] = 1;
                        else if (s == 'H') h[1][cN] = 1;
                        else if (s == 'D') h[2][cN] = 1;
                        else if (s == 'C') h[3][cN] = 1;
                    }
                }

                // rule 2
                for (int i = 0; i < 4; i++) {
                    if (h[i][12] == 1) {
                        int j;
                        for (j = 0; j < 13; j++) {
                            if (h[i][j] == 1 && j != 12)
                                break;
                        }
                        if (j == 13)
                            p -= 1;
                    }
                }

                // rule 3
                for (int i = 0; i < 4; i++) {
                    if (h[i][11] == 1) {
                        int k = 0;
                        for (int j = 0; j < 13; j++)
                            if (h[i][j] == 1 && j != 11)
                                k++;
                        if (k <= 1)
                            p -= 1;
                    }
                }

                // rule 4
                for (int i = 0; i < 4; i++) {
                    if (h[i][10] == 1) {
                        int k = 0;
                        for (int j = 0; j < 13; j++)
                            if (h[i][j] == 1 && j != 10)
                                k++;
                        if (k <= 2)
                            p -= 1;
                    }
                }

                // no-trump
                for (int i = 0; i < 4; i++) {
                    if (h[i][0] == 1)
                        stp[i] = true;
                    if (h[i][12] == 1) {
                        int k = 0;
                        for (int j = 0; j < 13; j++)
                            if (h[i][j] == 1 && j != 12)
                                k++;
                        if (k >= 1)
                            stp[i] = true;
                    }
                    if (h[i][11] == 1) {
                        int k = 0;
                        for (int j = 0; j < 13; j++)
                            if (h[i][j] == 1 && j != 11)
                                k++;
                        if (k >= 2)
                            stp[i] = true;
                    }
                }

                for (int i = 0; i < 4; i++)
                    if (stp[i] == false)
                        allStp = false;

                if (p >= 16 && allStp == true) {
                    System.out.println("BID NO-TRUMP");
                    continue;
                }

                // rules 5, 6, 7
                for (int i = 0; i < 4; i++) {
                    int k = 0;
                    for (int j = 0; j < 13; j++)
                        if (h[i][j] == 1)
                            k++;
                    if (k == 2)
                        p += 1;
                    else if (k == 1)
                        p += 2;
                    else if (k == 0)
                        p += 2;
                }

                for (int i = 0; i < 4; i++) {
                    int k = 0;
                    for (int j = 0; j < 13; j++)
                        if (h[i][j] == 1)
                            k++;
                    if (k > mstCrds) {
                        mstCrds = k;
                        bstBd = su[i];
                    }
                }

                if (p < 14)
                    System.out.println("PASS");
                else
                    System.out.println("BID " + bstBd);
            }
        }
    }

    private static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream));
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    String line = reader.readLine();
                    tokenizer = new StringTokenizer(line);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

    }
}
