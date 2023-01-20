import java.util.*;

public class Main {
    public static int n;
    public static int cnt;
    public static boolean[][] visited;
    public static int[][] Q;

    public static void dfs(int depth){
        if(n == depth){
            cnt++;
            return;
        }

        for (int i = 0; i < n; i++) {
            if(!visited[depth][i]){
                visited[depth][i] = true;
                Q[depth][i] = 1;

                attack(depth, i);
                dfs(depth + 1);

                visited[depth][i] = false;
                Q[depth][i] = 0;
                
                for (int j = 0; j < n; j++) {
                    Arrays.fill(visited[j], false);
                }

                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < n; k++) {
                        if(Q[j][k] == 1){
                            attack(j, k);
                        }
                    }
                }
            }
        }
    }

    public static void attack(int a, int b){
        for (int i = a; i < n; i++) { // 아래쪽
            visited[i][b] = true;
        }

        int c = a;
        int d = b;
        while (0 <= d && d < n & 0 <= c & c < n) { //대각선
            visited[c++][d--] = true;
        }
        while ((0 <= a && a < n & (0 <= b && b < n))) {
            visited[a++][b++] = true;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        cnt = 0;
        visited = new boolean[n][n];
        Q = new int[n][n];

        dfs(0);

        System.out.println(cnt);
    }
}
