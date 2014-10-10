import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * Created by Justin on 2/18/14.
 */
// Use exceptions next time to handle pieces that don't exist just for the heck of it.
public class p278 {
    private static class Board {
        int[][] board;
        Board(int m, int n) {
            board = new int[m][n];
        }
        boolean canPlacePiece(char p, int m, int n) {
            if (p == 'k')
                return canPlaceKnight(m, n);
            return !(board[m][n] == 1);
        }
        boolean canPlaceKnight(int m, int n) {
            if (board[m][n] == 1)
                return false;

            return false;
        }
        void placePiece(char p, int m, int n) {
            if (p == 'r')
                placeRook(m, n);
            else if (p == 'k')
                placeKnight(m, n);
            else if (p == 'Q')
                placeQueen(m, n);
            else if (p == 'K')
                placeKing(m, n);
            //printArray(board);
        }
        void placeRook(int m, int n) {
            for (int i = 0; i < board[0].length; i++)
                if (board[m][i] != 1)
                    board[m][i] = 1;
            for (int i = 0; i < board.length; i++)
                if (board[i][n] != 1)
                    board[i][n] = 1;
        }
        void placeKnight(int m, int n) {

        }
        void placeQueen(int m, int n) {

        }
        void placeKing(int m, int n) {

        }
    }
    private static void printArray(int[][] a) {
        System.out.println();
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++)
                System.out.print(a[i][j] + " ");
            System.out.println();
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int nP = Integer.parseInt(in.readLine());
        for (int i = 0; i < nP; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            char piece = st.nextToken().charAt(0);
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int max = 0;
            Board b = new Board(m, n);
            //printArray(b.board);
            for (int r = 0; r < m; r++) {
                for (int c = 0; c < n; c++) {
                    if (b.canPlacePiece(piece, r, c) == true) {
                        max++;
                        b.placePiece(piece, r, c);
                    }
                }
            }
            System.out.println(max);
        }

        in.close();
        out.close();
    }
}
