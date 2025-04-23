import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int count = 0;
        for(int i = a; i <= b ; i ++){
            if(isThree(i) || hasThree(i)){
                count ++;
            }
        }
        System.out.println(count);
    }
    
    static boolean isThree(int number){
        return number % 3 == 0 ? true : false;
    }

    static boolean hasThree(int number){
        String str = String.valueOf(number);
        return str.matches(".*[369].*");
    }
}