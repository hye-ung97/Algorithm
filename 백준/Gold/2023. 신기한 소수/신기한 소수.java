import java.util.Scanner;

public class Main {
    public static int N;

    public static void DFS(int number, int a){
        if(a==N){
            if(isPrime(number)){
                System.out.println(number);
            }
            return;
        }

        for (int i = 1; i < 10; i++) {
            int n = number * 10 + i;
            if((i % 2 != 0) && isPrime(n)){
                DFS(n,a+1);
            }
        }

    }

    public static boolean isPrime(int number){
        boolean check = true;
        for (int i = 2; i <= number/2; i++) {
            if(number % i == 0){
                check = false;
                break;
            }
        }
        return check;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        DFS(2,1);
        DFS(3,1);
        DFS(5,1);
        DFS(7,1);

    }
}
