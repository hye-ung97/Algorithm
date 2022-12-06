import java.util.*;

class Edge{
    int e;
    int value;

    public Edge(int e, int value) {
        this.e = e; // 노드
        this.value = value;//가중치
    }
}

public class Main {
    public static boolean[] visited;
    public static int[] distance;
    public static ArrayList<Edge>[] list;
    
    public static void BFS(int n){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        visited[n] = true;
        
        while (!queue.isEmpty()){
            int cur = queue.poll();
            for(Edge item : list[cur]){
                int e = item.e;
                int v = item.value;
                if(!visited[e]){
                    visited[e] = true;
                    queue.add(e);
                    distance[e] = distance[cur] + v;
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        list = new ArrayList[N+1];
        visited  = new boolean[N+1];
        distance = new int[N+1];

        for (int i = 0; i < N+1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            int node = sc.nextInt();
            while (true){
                int temp = sc.nextInt();
                if(temp == -1)  break;
                
                int v = sc.nextInt();
                list[node].add(new Edge(temp, v));
            }
        }
        
        BFS(1);
        int max = 1;

        for (int i = 2; i < N+1 ; i++) {
            if(distance[max] < distance[i]){
                max = i;
            }
        }

        visited  = new boolean[N+1];
        distance = new int[N+1];

        BFS(max);
        Arrays.sort(distance);
        System.out.println(distance[N]);
        
    }
}
