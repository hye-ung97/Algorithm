import java.util.Scanner;

public class Main {
    public static int strSum(String s){
        int sum = 0;
        String[] arr = s.split("[+]");
        for (int i = 0; i < arr.length; i++) {
            int temp = Integer.parseInt(arr[i]);
            sum +=temp;
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        String[] arr = str.split("-");

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            int tmp = strSum(arr[i]);
            if (i == 0) {
                sum += tmp;
            }
            else{
                sum = sum - tmp;
            }
        }
        System.out.println(sum);

    }
}
