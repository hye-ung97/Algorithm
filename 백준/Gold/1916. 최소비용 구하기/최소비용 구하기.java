import java.io.*;
import java.util.*;

public class Main {

    static ArrayList<ArrayList<Node>> graph;
    static boolean[] visitied;
    static int[] dist;

    static class Node{
        int to;
        int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public static int dijkstra(int start, int end){
        PriorityQueue<Node> pq = new PriorityQueue<>((x, y) -> x.weight - y.weight);
        pq.offer(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()){
            Node curNode = pq.poll();
            if(visitied[curNode.to]){
                continue;
            }
            visitied[curNode.to] = true;

            for (int i = 0; i < graph.get(curNode.to).size() ; i++) {
                Node abjNode = graph.get(curNode.to).get(i);
                if(!visitied[abjNode.to] && dist[abjNode.to] > curNode.weight + abjNode.weight){
                    dist[abjNode.to] = curNode.weight + abjNode.weight;
                    pq.offer(new Node(abjNode.to, dist[abjNode.to]));
                }
            }
        }

        return dist[end];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int city = Integer.parseInt(br.readLine());
        int bus = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();
        for (int i = 0; i < city + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < bus; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int f = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph.get(f).add(new Node(t, w));
        }

        visitied = new boolean[city + 1];
        dist = new int[city + 1];

        Arrays.fill(dist, Integer.MAX_VALUE);

        StringTokenizer st = new StringTokenizer(br.readLine());
        int result = dijkstra(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        System.out.println(result);
    }
}
