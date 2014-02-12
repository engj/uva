import java.io.*;
import java.util.*;
/**
 * Created by Justin on 2/10/14.
 */
public class p10141 {
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
            int k = 1;
            while (true) {
                int n = in.nextInt();
                int nP = in.nextInt();
                if (n == 0 && nP == 0)
                    System.exit(0);
                for (int i = 0; i < n; i++) {
                    in.next();
                    while (in.tokenizer.hasMoreTokens())
                        in.tokenizer.nextToken();
                }
                int bC =  0;
                double bP = Double.MAX_VALUE;
                String bN = "";
                for (int i = 0; i < nP; i++) {
                    String cmp = in.next();
                    while (in.tokenizer.hasMoreTokens())
                        cmp += " " + in.tokenizer.nextToken();
                    double p = in.nextDouble();
                    int c = in.nextInt();
                    if (c > bC || (p < bP && c == bC)) {
                        bC = c;
                        bP = p;
                        bN = cmp;
                    }
                    for (int j = 0; j < c; j++) {
                        in.next();
                        while (in.tokenizer.hasMoreTokens())
                            in.tokenizer.nextToken();
                    }
                }
                System.out.println();
                System.out.println("RFP #" + k);
                System.out.println(bN);
                k++;
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
