import java.io.*;
import java.util.*;

public class p12442 {
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out, true);
        p12442 solution = new p12442();
        solution.solve(in, out);
    }

    public void solve(InputReader in, PrintWriter out) {
        int numberCases = in.nextInt();
        for (int i = 0; i < numberCases; i++) {
            int numberMartians = in.nextInt();
            for (int j = 0; j < numberMartians; j++) {
                int start = in.nextInt();
                int end = in.nextInt();
                out.println(start + " " + end);
            }
        }
    }

    private static class InputReader {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
