import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by Justin on 2/10/14.
 */
public class p11507 {
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
            while (true) {
                int l = in.nextInt();
                if (l == 0)
                    break;
                int nB = l - 1;
                char cS = '+';
                char cA = 'x';
                for (int j = 1; j <= nB; j++) {
                    String b = in.next();
                    if (b.equals("No"))
                        continue;
                    char s = b.charAt(0);
                    char a = b.charAt(1);

                }
                System.out.println();
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
