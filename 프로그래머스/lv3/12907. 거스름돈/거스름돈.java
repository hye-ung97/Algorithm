class Solution {
    public int solution(int n, int[] money) {
        int[][] dp = new int[money.length + 1][n + 1];

        dp[0][0] = 1;
        for (int i = 1; i <= money.length; i++) {
            for (int j = 0; j < n + 1; j++) {
                if(money[i - 1] <= j){
                    dp[i][j] = dp[i - 1][j] + dp[i][j - money[i - 1]];
                }
                else{
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[money.length][n] % 1000000007;
    }
}