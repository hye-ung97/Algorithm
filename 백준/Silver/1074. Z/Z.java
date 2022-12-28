import java.io.*;
import java.util.*;

public class Main {
    static int N, R, C, cnt;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        R = sc.nextInt();
        C = sc.nextInt();

        search((int) Math.pow(2, N), R, C);
    }

    private static void search(int size, int r, int c) {
        if (size == 1) {
            System.out.println(cnt);
            return;
        }

        int n = size / 2;

        if (r < n && c < n) { // 1
            cnt += n * n * 0;
            search(n, r, c);
        } else if (r < n && c < n + n) { // 2
            cnt += n * n * 1;
            search(n, r, c - n);
        } else if (r < n + n && c < n) { // 3
            cnt += n * n * 2;
            search(n, r - n, c);
        } else if (r < n + n && c < n + n) { // 4
            cnt += n * n * 3;
            search(n, r - n, c - n);
        }
    }

}