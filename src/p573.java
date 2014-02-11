import java.io.*;
import java.util.*;

/**
 * Created by Justin on 2/10/14.
 */
public class p573 {
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
                int h = in.nextInt();
                int u = in.nextInt();
                int d = in.nextInt();
                double f = in.nextDouble() / 100;

                if (h == 0)
                    break;
                double cH = 0;
                int day = 1;
                double pClimbed = 0;
                double climbed = 0;
                cH += 0;
                while (true) {
                    if (day != 1)
                        climbed = pClimbed - (f * u);
                    else
                        climbed = u;
                    if (climbed > 0)
                        cH += climbed;
                    else
                        cH += 0;
                    if (cH > h) {
                        System.out.println("success on day " + day);
                        break;
                    }
                    cH -= d;
                    if (cH < 0) {
                        System.out.println("failure on day " + day);
                        break;
                    }
                    day++;
                    pClimbed = climbed;
                }
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
