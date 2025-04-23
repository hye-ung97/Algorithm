import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (isEven(n) && isFive(n)){
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    public static boolean isEven(int number){
        return number % 2 == 0 ? true : false;
    }

    public static boolean isFive(int number){
        int sum = (number / 10) + (number % 10);
        return sum % 5 == 0 ? true : false;
    }
}