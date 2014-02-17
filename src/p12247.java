import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * Created by Justin on 2/16/14.
 */
public class p12247 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        while (true) {
            StringTokenizer line = new StringTokenizer(in.readLine());
            int[] crds = new int[5];
            int numZeros = 0;
            boolean lost = false;

            for (int i = 0; i < 5; i++) {
                crds[i] = Integer.parseInt(line.nextToken());
                if (crds[i] == 0)
                    numZeros++;
            }

            if (numZeros == 5)
                break;

            for (int i = 3; i < 5; i++) {
                int numBeats = 0;
                for (int j = 0; j < 3; j++)
                    if (crds[i] > crds[j])
                        numBeats++;
                if (numBeats < 1)
                    lost = true;
            }

            if (lost == true) {
                System.out.println("-1");
                break;
            }



        }

        in.close();
        out.close();
    }
}
