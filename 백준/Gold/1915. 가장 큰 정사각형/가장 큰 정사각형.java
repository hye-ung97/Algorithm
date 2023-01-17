import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int solution(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return -1;
        }

        int maxVal = 0;

        int[][] dp = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                dp[i][j] = matrix[i][j];
                if(i != 0 && j != 0 && dp[i][j] != 0){
                    int up = dp[i][j - 1];
                    int left = dp[(i - 1)][j];
                    int ul = dp[(i - 1)][j - 1];

                    int minVal = Math.min(Math.min(up, left), ul);
                    dp[i][j] = minVal + 1;
                }
                maxVal = Math.max(maxVal, dp[i][j]);
            }
        }
        return maxVal * maxVal;
    }

    public static void main(String[] args) throws IOException {
                             
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());;

        int[][] data = new int[n][m];
        for (int i = 0; i < n; i++) {
            String temp = br.readLine();
            for (int j = 0; j < m; j++) {
                data[i][j] = Integer.parseInt(temp.substring(j, j + 1));
            }
        }

        System.out.println(solution(data));
    }
}
