import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int[] Honey;
    public static int N;
    public static int CNT;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        Honey = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(st.nextToken());
            Honey[i] = a;
        }

        CNT = 0;

        //벌 왼쪽 고정, 꿀통 오른쪽 고정

        for (int i = 1; i <= Honey.length - 2 ; i++) {
            int sum = 0;
            for (int j = 1; j <= Honey.length - 1; j++) {
                if(j == i){
                    continue;
                }
                sum += Honey[j];
            }
            for (int j = i + 1; j <= Honey.length - 1 ; j++) {
                sum += Honey[j];
            }
            CNT = Math.max(sum, CNT);
        }


        //벌 오른쪽 고정, 꿀통 왼쪽 고정
        for (int i = Honey.length - 2; i >= 0 ; i--) {
            int sum = 0;
            for (int j = Honey.length - 2; j >= 0 ; j--) {
                if(j == i){
                    continue;
                }
                sum += Honey[j];
            }
            for (int j = i - 1; j >= 0; j--) {
                sum += Honey[j];
            }
            CNT = Math.max(sum, CNT);
        }


        //벌 양쪽 고정, 꿀통 움직임
        for (int i = 1; i <= Honey.length - 2; i++) {
            int sum = 0;
            //왼쪽벌
            for (int j = 1; j <= i; j++) {
                sum += Honey[j];
            }
            //오른쪽벌
            for (int j = Honey.length - 2; j >= i ; j--) {
                sum += Honey[j];
            }
            CNT = Math.max(sum, CNT);
        }

        System.out.println(CNT);
    }
}
