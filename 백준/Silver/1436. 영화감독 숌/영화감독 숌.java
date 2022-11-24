import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt() ;
        String number = "666";

        int cnt=0;
        int num = 666;
        while (true){
            if(Integer.toString(num).contains(number)){
                cnt++;
            }
            if(cnt == N){
                break;
            }
            num++;
        }
        System.out.println(num);
    }
}
