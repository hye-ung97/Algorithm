import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static ArrayList<Integer>[] list;
    public static boolean[]  visited;
    public static Queue queue;

    public static void DFS(int item){
        if(!visited[item]){
            visited[item] = true;
            System.out.print(item+" ");
            for(int n : list[item]){
                if(!visited[n]){
                    DFS(n);
                }
            }
        }
    }
    public static void BFS(int item){
        int first = (int)queue.poll();
        visited[first] = true;
        System.out.print(first+" ");
        for(int n : list[item]){
            if(!visited[n] && !queue.contains(n)){
                queue.add(n);
            }
        }
        if(!queue.isEmpty()){
            BFS((int)queue.peek());
        }
        else{
            return;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        list = new ArrayList[N+1];

        for (int i = 0; i < N+1; i++) {
            list[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        for (int i = 1; i < N+1; i++) {
            Collections.sort(list[i]);
        }

        visited = new boolean[N+1];
        DFS(V);
        System.out.println();
        visited = new boolean[N+1];
        queue = new LinkedList();
        queue.add(V);
        BFS(V);
    }
}
