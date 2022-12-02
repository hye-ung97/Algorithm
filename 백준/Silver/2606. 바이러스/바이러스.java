import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static ArrayList<Integer>[] list;
    public static boolean[] visitied;
    public static void DFS(int cur){

        visitied[cur] = true;
        for(int item : list[cur]){
            if(!visitied[item]){
                DFS(item);
            }
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());

        list = new ArrayList[N+1];
        visitied = new boolean[N+1];

        for (int i = 0; i < N+1; i++) {
            list[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            list[s].add(e);
            list[e].add(s);
        }

        DFS(1);
        int cnt = 0;
        for(boolean item : visitied){
            if(item){
                cnt++;
            }
        }
        System.out.println(cnt-1);
    }
}
