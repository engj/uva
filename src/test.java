import java.io.*;
import java.util.*;
public class test {
    private static int[] insertionSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int temp = a[i];
            int j;
            for (j = i - 1; j > 0; j--) {
                if (a[j] > temp)
                    a[j + 1] = a[j];
                else
                    break;
            }
            a[j + 1] = temp;
        }
        return a;
    }
    public static void main(String[] args) {
        int[] a = new int[6];
        a[0] = 1;
        a[1] = 2;
        a[2] = 3;
        a[3] = 3;
        a[4] = 2;
        a[5] = 1;
        a = insertionSort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}