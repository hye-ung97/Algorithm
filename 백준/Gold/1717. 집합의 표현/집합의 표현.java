import java.util.Scanner;

public class Main {
    public static int[] arr;
    public static int find(int a){
        if(arr[a] == a){
            return a;
        }
        else{
            return arr[a] = find(arr[a]);
        }
    }
    public static void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a != b){
            arr[b] = a;
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        arr = new int[n+1];

        for (int i = 1; i < n+1; i++) {
            arr[i] = i;
        }

        for (int i = 0; i < m; i++) {
            int check = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();

            if (check == 0) {
                union(a, b);
            }
            else{
                if(find(a) == find(b)){
                    System.out.println("YES");
                }
                else{
                    System.out.println("NO");
                }
            }
        }
    }
}
