import java.io.*;
import java.util.*;

public class Main {
    public static int[][] maze;
    public static boolean[][] visited;
    static int N;
    static int M;

    public static void BFS(int x, int y){
        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};

        Queue<int []> queue = new LinkedList();
        queue.add(new int[] {x,y});
        visited[x][y] = true;

        while (!queue.isEmpty()){
            int[] cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int newX = cur[0] + dx[i];
                int newY = cur[1] + dy[i];
                if(newX >=0 && newY >=0 && newX < N && newY < M){
                    if(!visited[newX][newY] && maze[newX][newY] != 0){
                        visited[newX][newY] = true;
                        maze[newX][newY] = maze[cur[0]][cur[1]] + 1;
                        queue.add(new int[] {newX,newY});
                    }
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        maze = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            String line = st.nextToken();
            for (int j = 0; j < M; j++) {
                maze[i][j] = Integer.parseInt(line.substring(j,j+1));
            }
        }
        BFS(0,0);
        System.out.println(maze[N-1][M-1]);
    }
}
