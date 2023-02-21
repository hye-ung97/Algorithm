import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class Main {
    static int N, maxLen;
    static int[] B = new int[1000001];
    static int[] A = new int[1000001];
    static int[] D = new int[1000001];
    static int[] ans = new int[1000001];
    
    static int binarySearch(int l, int r, int now){
        int mid;
        while (l < r){
            mid = (l + r) / 2;
            if(B[mid] < now){
                l = mid + 1;
            } else{
                r = mid;
            }
        }
        
        return l;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N ; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        int index;
        B[++maxLen] = A[1];
        D[1] = 1;

        for (int i = 2; i <= N; i++) {
            if(B[maxLen] < A[i]){
                B[++maxLen] = A[i];
                D[i] = maxLen;
            } else{
                index = binarySearch(1, maxLen, A[i]);
                B[index] = A[i];
                D[i] = index;
            }
        }

        System.out.println(maxLen);
        
        index = maxLen;
        int x = B[maxLen] + 1;
        for (int i = N; i >= 1 ; i--) {
            if(D[i] == index && A[i] < x){
                ans[index] = A[i];
                x = A[i];
                index--;
            }
        }

        for (int i = 1; i <=maxLen ; i++) {
            System.out.println(ans[i] + " ");
        }
    }
}
