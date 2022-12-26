import java.io.*;
import java.util.*;

public class Main {
    public static int n;
    public static int m;
    public static char[] arr;
    public static boolean[] visitied;

    public static void combine (int start, int cnt){
        if(cnt == n) {
            isCheck();
        }

        for (int i = start; i < m; i++) {
            visitied[i] = true;
            combine(i+1, cnt + 1);
            visitied[i] = false;
        }
    }

    public static void isCheck(){
        StringBuffer sb = new StringBuffer();
        int a = 0 ;
        int b = 0;

        for (int i = 0; i < m; i++) {
            if(visitied[i]){
                sb.append(arr[i]);
                if(arr[i] == 'a' || arr[i] == 'e'|| arr[i] == 'i' || arr[i] == 'o' || arr[i] == 'u'){
                    a++;
                }
                else{
                    b++;
                }
            }
        }

        if(a >= 1 && b >= 2){
            System.out.println(sb);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new char[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            arr[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(arr);

        visitied = new boolean[m];

        combine(0,0);
    }
}
