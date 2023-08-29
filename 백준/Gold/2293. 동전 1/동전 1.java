import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int solution(int sum, int[] coins){
        int[] dp = new int[sum + 1];
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = 1; j <= sum; j++) {
                if (j >= coins[i])
                    dp[j] += dp[j - coins[i]];
            }
        }

        return dp[sum];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] coins = new int[n];

        for(int i = 0; i < n; i++){
            coins[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(solution(k, coins));
    }
}
