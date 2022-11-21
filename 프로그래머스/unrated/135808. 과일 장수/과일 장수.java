import java.util.Arrays;
import java.util.Collections;

class Solution {
    public int solution(int k, int m, int[] score) {
        int result = 0;
        
        Integer[] tmp = Arrays.stream(score).boxed().toArray(Integer[]::new);
        Arrays.sort(tmp, Collections.reverseOrder());
        

        for (int i = 0; i < score.length/m; i++) {
            int[] sub = new int[m];
            for (int j = 0; j < m; j++) {
                sub[j] = tmp[(i*m)+j];
            }
            result = result + sub[m-1] * m;
        }
        return result;
    }
}