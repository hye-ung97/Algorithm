import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static ArrayList<Integer>[] list;
    public static boolean[] visitied;
    
    public static void DFS(int i){
        if(visitied[i]){
            return;
        }
        
        visitied[i] = true;
        for(int item : list[i]){
            if(!visitied[item]){
                DFS(item);
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        list = new ArrayList[N+1];
        for (int i = 0; i < N+1; i++) {
            list[i]  = new ArrayList<Integer>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }
        
        int cnt = 0;
        visitied = new boolean[N+1];
        for (int i = 1; i < N+1; i++) {
            if(!visitied[i]){
                cnt++;
                DFS(i);
            }
        }
        System.out.println(cnt);
    }
}
