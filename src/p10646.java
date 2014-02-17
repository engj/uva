import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * Created by Justin on 2/15/14.
 */
// Struggled with indexes. Should practice this one again in the future..
public class p10646 {
    private static int cardVal(String c) {
        char r = c.charAt(0);
        if (r >= '2' && r <= '9') {
            return Character.getNumericValue(r);
        }
        return 10;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int n = Integer.parseInt(in.readLine());
        for (int i = 1; i <= n; i++) {
            String[] crds = in.readLine().split("\\s+");
            int top = 26;
            int y = 0;
            for (int j = 0; j < 3; j++) {
                String tC = crds[top];
                int x = cardVal(tC);
                y += x;
                top--;
                if (x != 10)
                    top -= 10 - x;
            }
            // Did not check for this condition the first time and recieved a WA.
            if (y <= top) {
                out.println("Case " + i + ": " + crds[y]);
            } else {
                out.println("Case " + i + ": " + crds[25 + y - top]);
            }
        }
        in.close();
        out.close();
    }
}
