import java.util.Scanner;

public class Main {
    public static int[][] map = new int[64][64];
    public static int s, N, K, R1, R2, C1, C2;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        s = sc.nextInt();
        N = sc.nextInt();
        K = sc.nextInt();
        R1 = sc.nextInt();
        R2 = sc.nextInt();
        C1 = sc.nextInt();
        C2 = sc.nextInt();

        divide(0,0,(int)Math.pow(N,s),false);

        for (int i = 0; i <= R2 - R1 ; i++) {
            for (int j = 0; j <= C2 - C1 ; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }
    
    public static void divide(int x, int y, int size, boolean isBlack){
        if(x > C2 || x + size <= C1|| y > R2 || y + size <= R1){
            return;
        }

        if(size==1){
            map[y-R1][x-C1] = isBlack? 1 : 0;
            return;
        }

        int nSize = size / N;
        int blackStart = (N - K) / 2;
        int blackEnd = N - blackStart;

        for(int i = 0; i< N; i++){
            int nY = y + nSize * i;
            for(int j = 0; j < N; j++){
                int nX = x + nSize * j;
                divide(nX, nY , nSize, isBlack || (i >= blackStart && i < blackEnd) && (j >= blackStart && j < blackEnd));
            }
        }
    }
}
