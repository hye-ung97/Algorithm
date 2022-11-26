import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        for (int i = 0; i < str.length(); i=i+10) {
            int start = i;
            int end = i+10;
            if(end > str.length()){
                end = str.length();
            }
            System.out.println(str.substring(start, end));
        }
    }
}
