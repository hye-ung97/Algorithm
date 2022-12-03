import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[][] maze;
    static boolean[][] visited;
    static int cnt;

    static void BFS(int a, int b){
        Queue<int[]> queue = new LinkedList<>();
        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};

        visited[a][b] = true;
        queue.add(new int[]{a, b});

        while (!queue.isEmpty()){
            int[] cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int newX = cur[0] + dx[i];
                int newY = cur[1] + dy[i];
                if(newX >=0 && newY >=0 && newX < N && newY < N){
                    if(!visited[newX][newY] && maze[newX][newY] != 0){
                        visited[newX][newY] = true;
                        cnt++;
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
        maze = new int[N][N];
        visited = new boolean[N][N];
        ArrayList<Integer> list = new ArrayList();


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            String line = st.nextToken();
            for (int j = 0; j < N; j++) {
                maze[i][j] = Integer.parseInt(line.substring(j,j+1));
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(maze[i][j]==1 && !visited[i][j]){
                    cnt = 1;
                    BFS(i,j);
                    list.add(cnt);
                }
            }
        }

        Collections.sort(list);
        System.out.println(list.size());
        for(int item : list){
            System.out.println(item);
        }

    }
}
