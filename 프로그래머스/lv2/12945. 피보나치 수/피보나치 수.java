import java.util.Arrays;

public class Solution {
    public static int[] D;
    public static int fibo(int n){
        if(D[n] != -1){
            return D[n];
        }
        return D[n] = (fibo(n - 1) + fibo(n - 2)) % 1234567;
    }
    public static int solution (int n){
        D = new int[n + 1];
        Arrays.fill(D, -1);
        D[0] = 0;
        D[1] = 1;
        fibo(n);
        return D[n];
    }
}
