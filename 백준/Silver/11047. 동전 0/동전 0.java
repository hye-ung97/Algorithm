import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int target = sc.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int cnt = 0;
        for (int i = N-1; i >= 0; i--) {
            if(arr[i] <= target){
                int temp = target / arr[i];
                cnt += temp;
                target = target % arr[i];
            }
        }
        System.out.println(cnt);
    }
}
