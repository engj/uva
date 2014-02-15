import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by Justin on 2/14/14.
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
                int p = 0;
                int[] hR = new int[13];
                int[] hS = new int[4];
                char[] su = new char[4];
                su[0] = 'S'; su[1] = 'H'; su[2] = 'D'; su[3] = 'C';
                char[] stp = new char[4];
                boolean[] stpp = new boolean[4];

                String line;
                try {
                    line = in.reader.readLine();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                StringTokenizer st = new StringTokenizer(line);

                while (st.hasMoreTokens()) {
                    String c = st.nextToken();
                    char r = c.charAt(0);
                    char s = c.charAt(1);

                    if (s == 'S') hS[0]++;
                    else if (s == 'H') hS[1]++;
                    else if (s == 'D') hS[2]++;
                    else if (s == 'C') hS[3]++;

                    if (r == 'A') {
                        p += 4;
                        hR[0]++;
                        if (s == 'S') stp[0] = 'A';
                        else if (s == 'H') stp[1] = 'A';
                        else if (s == 'D') stp[2] = 'A';
                        else if (s == 'C') stp[3] = 'A';
                    } else if (r == 'K') {
                        p += 3;
                        hR[12]++;
                        if (s == 'S') stp[0] = 'K';
                        else if (s == 'H') stp[1] = 'K';
                        else if (s == 'D') stp[2] = 'K';
                        else if (s == 'C') stp[3] = 'K';
                    } else if (r == 'Q') {
                        p += 2;
                        hR[11]++;
                        if (s == 'S') stp[0] = 'Q';
                        else if (s == 'H') stp[1] = 'Q';
                        else if (s == 'D') stp[2] = 'Q';
                        else if (s == 'C') stp[3] = 'Q';
                    } else if (r == 'J') {
                        p += 1;
                        hR[10]++;
                    } else if (r == 'T') {
                        hR[9]++;
                    } else {
                        hR[Character.getNumericValue(r) - 1]++;
                    }
                }

                if (hR[12] == 1) p--;
                if (hR[11] == 1 || hR[11] == 2) p--;
                if (hR[10] == 1 || hR[10] == 2 || hR[10] == 3) p--;

                for (int i = 0; i < 4; i++) {
                    if (stp[i] == 'A') stpp[i] = true;
                    if (stp[i] == 'K' && hS[i] >= 2) stpp[i] = true;
                    if (stp[i] == 'Q' && hS[i] >= 3) stpp[i] = true;
                }

                boolean allStopped = true;
                for (int i = 0; i < 4; i++) {
                    if (stpp[i] == false) allStopped = false;
                }

                if (p >= 16 && allStopped == true) {
                    System.out.println("BID NO-TRUMP");
                    break;
                }

                int m = 0;
                for (int i = 0; i < 4; i++) {
                    if (hS[i] == 2) p += 1;
                    else if (hS[i] == 1 || hS[i] == 0) p += 2;
                    if (hS[i] > hS[m]) m = i;
                }

                if (p < 14)
                    System.out.println("PASS");
                else
                    System.out.println("BID " + su[m]);

                break;
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
