import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.System.exit;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        boolean check = false;

        for (int i = 0; i < str.length() / 2; i++) {
            char start = str.charAt(i);
            char end = str.charAt(str.length() - i - 1);
            if (start != end){
                System.out.println(str.length());
                exit(0);
            }
            if(start != str.charAt(i + 1)){
                check = true;
            }
        }

        if(check){
            System.out.println(str.length() - 1);
        }
        else{
            System.out.println(-1);
        }
    }
}
