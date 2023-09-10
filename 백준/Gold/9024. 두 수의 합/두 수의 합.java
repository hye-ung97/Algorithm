import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());

        for (int i = 0; i < test; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            System.out.println(find(k, arr));
        }
    }

    public static int find(int target, int[] arr){
        int answer = 0;
        int left = 0;
        int right = arr.length - 1;

        Arrays.sort(arr);
        int gap = Integer.MAX_VALUE;

        while (left < right){
            int sum = arr[left] + arr[right];
            int curGap = Math.abs(sum - target);
            if(gap >= curGap){
                if(gap > curGap){
                    answer = 0;
                }
                answer++;
                gap = curGap;
            }

            if(sum >= target){
                right--;
            }
            else{
                left++;
            }
        }

        return answer;
    }
}
