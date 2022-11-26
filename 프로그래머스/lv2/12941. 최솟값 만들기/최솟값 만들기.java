import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;

        ArrayList list = new ArrayList<Integer>();
        for (int item : B){
            list.add(item);
        }
        Arrays.sort(A);
        list.sort(Collections.reverseOrder());

        for (int i = 0; i < A.length; i++) {
            answer = answer + A[i] * (int)list.get(i);
        }

        return answer;
    }
}