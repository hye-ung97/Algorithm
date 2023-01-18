import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] distance;
    static int city, bus;
    static final int MAX = 10000001;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        city = Integer.parseInt(br.readLine());
        bus = Integer.parseInt(br.readLine());
        distance = new int[city + 1][city + 1];

        for (int i = 1; i <= city; i++) {
            for (int j = 1; j <= city; j++) {
                if(i == j){
                    distance[i][j] = 0;
                }
                else{
                    distance[i][j] = MAX;
                }
            }
        }

        input();
        floyd();
        print();

    }

    public static void input() throws IOException {
        for (int i = 0; i < bus; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(distance[a][b] > c)  distance[a][b] = c;
        }
    }

    public static void floyd(){
        for (int k = 1; k <= city; k++) {
            for (int i = 1; i <= city; i++) {
                for (int j = 1; j <= city; j++) {
                    if(distance[i][j] > distance[i][k] + distance[k][j]){
                        distance[i][j] = distance[i][k] + distance[k][j];
                    }
                }
            }
        }
    }

    public static void print(){
        for (int i = 1; i <= city; i++) {
            for (int j = 1; j <= city; j++) {
                if(distance[i][j] == MAX){
                    System.out.print(0 + " ");
                }
                else{
                    System.out.print(distance[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}
