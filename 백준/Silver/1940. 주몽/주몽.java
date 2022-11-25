import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] input = new int[N];
        for (int i = 0; i < N; i++) {
            input[i] = sc.nextInt();
        }

        Arrays.sort(input);

        int start = 0;
        int end = N-1;
        int sum =0;
        int cnt=0;
        while (start<end){
            sum = input[start]+input[end];
            if(sum < M){
                start++;
            }
            else if(sum>M){
                end--;
            } else if (sum==M) {
                cnt++;
                start++;
                end--;
            }
        }
        System.out.println(cnt);
    }
}
