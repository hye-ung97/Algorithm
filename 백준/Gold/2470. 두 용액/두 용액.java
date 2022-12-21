import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int left = 0;
        int right = arr.length-1;
        int min = Integer.MAX_VALUE;
        int[] answer = new int[2];

        while (left < right){
            int sum = arr[left] + arr[right];
            int sum2 = Math.abs(sum);

            if(sum2 < min){
                min = sum2;
                answer[0] = arr[left];
                answer[1] = arr[right];
            }

            if(sum > 0){
                right--;
            }
            else{
                left++;
            }
        }
        for(int item : answer){
            System.out.print(item + " ");
        }
        System.out.println();
    }
}
