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
            int p = 0;
            while(true) {

                int[] h = new int[13];
                char r = in.next().charAt(0);
                if (r == 'A') {
                    p += 4;
                    h[0]++;
                } else if (r == 'K') {
                    p += 3;
                    h[12]++;
                } else if (r == 'Q') {
                    p += 2;
                    h[11]++;
                } else if (r == 'J') {
                    p += 1;
                    h[10]++;
                } else if (r== 'T') {
                    h[9]++;
                } else {
                    h[Character.getNumericValue(r) - 1]++;
                }
                if (h[12] == 1) p--;
                if (h[11] == 1 || h[11] == 2) p--;
                if (h[10] == 1 || h[10] == 2 || h[10] == 3) p--;
                for (int i = 0; i < 13; i++) {
                    if (h[i] == 2) p++;
                    if (h[i] == 1) p += 2;
                    if (h[i] == 0) p +=2;
                }
                System.out.println(p);
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
