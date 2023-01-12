import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, 1, 0, -1 };
    static int N, M;
    static int[][] map;

    static class Point implements Comparable<Point> {
        int x;
        int y;
        int cnt;

        Point(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Point o) {
            return cnt - o.cnt;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            String temp = br.readLine();
            for (int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(temp.substring(j-1,j));
            }
        }

        int ans = BFS(1, 1);

        System.out.println(ans);
    }

    public static int BFS(int x, int y) {
        PriorityQueue<Point> q = new PriorityQueue<>();

        q.offer(new Point(x, y, 0));
        boolean[][] visit = new boolean[N + 1][M + 1];
        visit[x][y] = true;

        int newX, newY;
        while (!q.isEmpty()) {
            Point cur = q.poll();
            
            if (cur.x == N && cur.y == M) {
                return cur.cnt;
            }

            for (int i = 0; i < 4; i++) {
                newX = cur.x + dx[i];
                newY = cur.y + dy[i];

                if (newX < 1 || newY < 1 || newX > N || newY > M) {
                    continue;
                }

                if (!visit[newX][newY] && map[newX][newY] == 0) {
                    visit[newX][newY] = true;
                    q.offer(new Point(newX, newY, cur.cnt));
                }

                if (!visit[newX][newY] && map[newX][newY] == 1) {
                    visit[newX][newY] = true;
                    q.offer(new Point(newX, newY, cur.cnt + 1));
                }
            }
        }
        return 0;
    }
}
