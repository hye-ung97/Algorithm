import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static ArrayList<Integer>[] list;
    public static boolean[] visitied;
    public static boolean check;

    public static void DFS(int friend, int depth){
        if(depth==5 || check){
            check = true;
            return;
        }

        visitied[friend] = true;
        for(int item : list[friend]){
            if(!visitied[item]){
                DFS(item, depth+1);
            }
        }

        visitied[friend] = false;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        list = new ArrayList[N];
        visitied = new boolean[N];
        check = false;

        for (int i = 0; i < N; i++) {
            list[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            list[s].add(e);
            list[e].add(s);
        }

        for (int i = 0; i < N; i++) {
            DFS(i, 1);
            if(check){
                break;
            }
        }
        if(check){
            System.out.println("1");
        }
        else{
            System.out.println("0");
        }

    }
}
