import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int N;
    public static int M;
    public static int[][] box;
    public static boolean[][] visited;

    public static Queue<int []> queue;
    public static void DFS(){
        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};

        while (!queue.isEmpty()){
            int[] cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int A = cur[0] + dx[i];
                int B = cur[1] + dy[i];
                if(A >=0 && B >=0 && A < N && B < M) {
                    if (box[A][B] == 0 && !visited[A][B]) {
                        box[A][B] = box[cur[0]][cur[1]]+1;
                        visited[A][B] = true;
                        queue.add(new int[]{A, B});
                    }
                }
            }
        }
    }


    public static int check(){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(box[i][j] == 0){
                    return -1;
                }
            }
        }
        return 0;
    }

    public static int Max(){
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(box[i][j] > max){
                    max = box[i][j];
                }
            }
        }
        return max -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        M = Integer.parseInt(st.nextToken()); //가로
        N = Integer.parseInt(st.nextToken()); // 세로
        box = new int[N][M];
        visited = new boolean[N][M];
        queue = new LinkedList();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < M; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if(box[i][j] == 1){
                    queue.add(new int[] {i,j});
                }
            }
        }

        DFS();

        if(check() == -1){
            System.out.println(-1);
        }
        else{
            System.out.println(Max());
        }

    }
}
