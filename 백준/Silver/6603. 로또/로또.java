import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int len = Integer.parseInt(st.nextToken());
            if(len == 0){
                break;
            }

            int[] arr = new int[len];
            for (int i = 1; i <= len ; i++) {
                arr[i-1] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);

            boolean[] visitied = new boolean[len];
            BackTracking(arr, visitied, 0, 0);
            System.out.println();
        }
    }

    public static void BackTracking(int[] arr, boolean[] visitied, int depth, int start){
        if(depth == 6){
            for (int i = 0; i < visitied.length; i++) {
                if(visitied[i]){
                    System.out.print(arr[i] + " ");
                }
            }
            System.out.println();
            return;
        }

        for (int i = start; i < arr.length; i++) {
            if(!visitied[i]){
                visitied[i] = true;
                BackTracking(arr, visitied, depth + 1, i);
                visitied[i] = false;
            }
        }

    }
}
