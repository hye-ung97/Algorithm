import java.util.Scanner;

public class Main {

    static int[][] HOME;
    static int[][] DP;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HOME = new int[n][3];
        DP = new int[n][3];

        for (int i = 0; i < n; i++) {
            HOME[i][0] = sc.nextInt();
            HOME[i][1] = sc.nextInt();
            HOME[i][2] = sc.nextInt();
        }

        DP[0][0] = HOME[0][0];
        DP[0][1] = HOME[0][1];
        DP[0][2] = HOME[0][2];

        int result = Math.min(paint(n - 1, 0), Math.min(paint(n - 1, 1), paint(n - 1, 2)));
        System.out.println(result);
    }
    public static int paint(int n, int color){
        if(DP[n][color] == 0){
            if(color == 0){
                DP[n][0] = Math.min(paint(n - 1, 1), paint(n - 1, 2)) + HOME[n][0];
            }
            else if(color == 1){
                DP[n][1] = Math.min(paint(n - 1, 0), paint(n - 1, 2)) + HOME[n][1];
            }
            else if(color == 2){
                DP[n][2] = Math.min(paint(n - 1, 0), paint(n - 1, 1)) + HOME[n][2];
            }
        }

        return DP[n][color];
    }
}
