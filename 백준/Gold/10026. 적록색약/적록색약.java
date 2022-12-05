import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static int N;
    public static char[][] photo;
    public static boolean[][] visited;

    public static void DFS (int a, int b){
        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};

        Queue<int[]> queue = new LinkedList();
        queue.add(new int[] {a,b});
        visited[a][b] = true;

        while (!queue.isEmpty()){
            int[] cur = queue.poll();
            char rgb = photo[cur[0]][cur[1]];
            for (int i = 0; i < 4; i++) {
                int A = cur[0] + dx[i];
                int B = cur[1] + dy[i];
                if(A >=0 && B >=0 && A < N && B < N) {
                    if (photo[A][B] == rgb && !visited[A][B]) {
                        visited[A][B] = true;
                        queue.add(new int[]{A, B});
                    }
                }
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        photo = new char[N][N];
        visited = new boolean[N][N];
        int part = 0;
        int green = 0;

        for (int i = 0; i < N; i++) {
            char[] str = sc.next().toCharArray();
            for (int j = 0; j < N; j++) {
                photo[i][j] = str[j];
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(!visited[i][j]){
                    DFS(i,j);
                    part++;
                }
            }
        }

        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(photo[i][j] == 'R' || photo[i][j] == 'G'){
                    photo[i][j] = 'T';
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(!visited[i][j]){
                    DFS(i,j);
                    green++;
                }
            }
        }

        System.out.println(part + " " +green);

    }
}
