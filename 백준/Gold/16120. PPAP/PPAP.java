import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int pCnt = 0;
        boolean check = true;
        for (int i = 0; i < str.length(); i++) {
            char cur = str.charAt(i);
            if(cur == 'P'){
                pCnt++;
            }
            else if(cur == 'A' && pCnt >= 2){
                if(i < str.length() - 1 && str.charAt(i + 1) == 'P'){
                    pCnt--;
                    i++;
                }
            }
            else{
                check = false;
                break;
            }
        }

        if(pCnt == 1 && check){
            System.out.println("PPAP");
        }
        else{
            System.out.println("NP");
        }
    }
}
