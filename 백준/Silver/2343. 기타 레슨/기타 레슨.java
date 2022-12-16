import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cd = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int start = Arrays.stream(arr).max().getAsInt();
        int end = Arrays.stream(arr).sum();

        while (start <= end){
            int mid = (start + end) / 2;
            int sum = 0;
            int cnt = 0;

            for (int i = 0; i < n; i++) {
                if(sum + arr[i] > mid){
                    sum = 0;
                    cnt ++;
                }
                sum+=arr[i];
            }
            if(sum != 0){
                cnt++;
            }
            if(cnt > cd){
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }

        System.out.println(start);

    }
}
