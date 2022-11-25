import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long[] numbers = new long[N];
        int goodNum=0;
        for (int i = 0; i < N; i++) {
            numbers[i] = sc.nextLong();
        }

        Arrays.sort(numbers);

        for (int i = 0; i < N; i++) {
            long find = numbers[i];
            int left = 0;
            int right = N-1;
            while (left < right){
                if(i==left) left++;
                if(i==right) right--;
                if(left >= right) break;

                if(numbers[left] + numbers[right] < find){
                    left++;
                }
                else if(numbers[left] + numbers[right] > find){
                    right--;
                }
                else if(numbers[left] + numbers[right] == find){
                    goodNum++;
                    break;
                }
            }
        }


        System.out.println(goodNum);
    }
}
