import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] nArr = new int[n];

        for (int i = 0; i < n; i++) {
            nArr[i] = sc.nextInt();
        }

        Arrays.sort(nArr);

        int start = 0;
        int end = 0;
        int min = Integer.MAX_VALUE;


        while (end < n ){
            int temp = nArr[end] - nArr[start];
            if(temp > m){
                start++;
                min = Math.min(min, temp);
            }
            else if(temp < m){
                end++;
            }
            else if(temp == m){
                min = m;
                break;
            }
        }

        System.out.println(min);
    }
}
