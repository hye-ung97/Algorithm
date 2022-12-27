import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arr = new int[m];
        boolean[] visited = new boolean[n+1];

        BackTracking(arr, visited, 0, m, n);
    }

    public static void BackTracking(int[] arr, boolean[] visitied, int len, int m, int n){
        if(len == m){
            for(int item : arr){
                System.out.print(item + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= n ; i++) {
            if(!visitied[i]){
                visitied[i] = true;
                arr[len] = i;
                BackTracking(arr, visitied, len + 1, m, n);
                visitied[i] = false;
            }
        }
    }
}
