import java.util.Arrays;
class Solution {
    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);

        int cnt = 0;

        int len = A.length - 1;
        int idx = len;
        for (int i = len; i >= 0 ; i--) {
            if(A[i] < B[idx]){
                cnt++;
                idx--;
            }
        }

        return cnt;
    }
}