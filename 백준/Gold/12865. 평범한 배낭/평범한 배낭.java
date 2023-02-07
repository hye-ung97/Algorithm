import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static class item{
        int W;
        int V;

        public item(int w, int v) {
            W = w;
            V = v;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        item[] bags = new item[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            bags[i] = new item(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }

        int[][] dp = new int[N + 1][K + 1];

        for (int i = 0; i < N; i++) {
            for (int j = 1; j <= K; j++) {
                if (bags[i].W > j) {
                    dp[i + 1][j] = dp[i][j];
                }
                else {
                    dp[i + 1][j] = Math.max(dp[i][j], dp[i][j - bags[i].W] + bags[i].V);
                }
            }
        }
        System.out.println(dp[N][K]);
    }
}
