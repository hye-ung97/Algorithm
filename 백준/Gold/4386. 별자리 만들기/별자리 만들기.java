import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static int[] parent;
    public static PriorityQueue<Edge> graph;

    public static class Point{
        double x;
        double y;
        int idx;

        public Point(double x, double y, int idx) {
            this.x = x;
            this.y = y;
            this.idx = idx;
        }
    }

    public static class Edge implements Comparable<Edge> {
        int start;
        int end;
        double v;

        public Edge(int start, int end, double v) {
            this.start = start;
            this.end = end;
            this.v = v;
        }

        @Override
        public int compareTo(Edge o) {
            if(this.v < o.v){
                return -1;
            }
            else{
                return 1;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Point[] points = new Point[N];
        for (int i = 0; i < N; i++) {
            double x = sc.nextDouble();
            double y = sc.nextDouble();
            points[i] = new Point(x, y, i);
        }

        graph = new PriorityQueue<>();
        parent = new int[N + 1];
        for (int i = 0; i < N + 1; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                double temp = dist(points[i], points[j]);
                graph.offer(new Edge(points[i].idx, points[j].idx, temp));
            }
        }

        double result = 0;
        int cnt = 0;
        while (!graph.isEmpty()){
            Edge cur = graph.poll();
            if(find(cur.start) != find(cur.end)){
                union(cur.start, cur.end);
                cnt = cnt + 1;
                result += cur.v;
            }
            if(cnt == N){
                break;
            }
        }

        System.out.printf("%.2f", result);

    }

    public static double dist (Point p1, Point p2){
        return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
    }

    public static void union(int x, int y){
        x = find(x);
        y = find(y);
        if(x != y){
            parent[y] = x;
        }
    }
    public static int find(int a){
        if(a == parent[a]){
            return a;
        }
        else{
            return parent[a] = find(parent[a]);
        }
    }
}
