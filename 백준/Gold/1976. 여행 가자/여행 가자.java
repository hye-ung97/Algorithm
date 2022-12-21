import java.util.Scanner;

public class Main {
    public static int[] parent;
    public static void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a != b){
            parent[b] = a;
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
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] map = new int[n+1][n+1];
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < n+1; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        int[] route = new int[m];
        for (int i = 0; i < m; i++) {
            route[i] = sc.nextInt();
        }

        parent = new int[n+1];
        for (int i = 1; i < n+1; i++) {
            parent[i] = i;
        }

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < n+1; j++) {
                if(map[i][j] == 1){
                    union(i,j);
                }
            }
        }

        boolean check = true;

        for (int i = 0; i < route.length-1 ; i++) {
            if(find(route[i]) != find(route[i+1])){
                check = false;
                break;
            }
        }

        if(check){
            System.out.println("YES");
        }
        else{
            System.out.println("NO");
        }

    }
}
