import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        int max = arr[n-1];
        int cnt = 1;
        for (int i = n-1; i > -1 ; i--) {
            int temp = arr[i] * cnt++;
            max = max < temp? temp: max;
        }

        System.out.println(max);
    }
}
