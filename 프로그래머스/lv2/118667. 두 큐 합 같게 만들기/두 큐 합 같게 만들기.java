import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static int solution(int[] queue1, int[] queue2) {
        long q1Sum = (long) Arrays.stream(queue1).sum();
        long q2Sum = (long) Arrays.stream(queue2).sum();
        long total = q1Sum + q2Sum;

        if(total % 2 != 0){
            return -1;
        }

        total = total / 2;

        Queue<Long> q1 = new LinkedList<>();
        Queue<Long> q2 = new LinkedList<>();
        for(int item : queue1){
            q1.add((long)item);
        }
        for(int item : queue2){
            q2.add((long)item);
        }

        int cnt = 0;

        for (int i = 0; i <= queue1.length + queue2.length + 2; i++) {
            if(q1Sum == q2Sum){
                return cnt;
            }

            if(q1Sum > total){
                long temp = q1.poll();
                q2.add(temp);
                q1Sum = q1Sum - temp;
                q2Sum = q2Sum + temp;

            }
            else{
                long temp = q2.poll();
                q1.add(temp);
                q1Sum = q1Sum + temp;
                q2Sum = q2Sum - temp;
            }
            cnt++;
        }

        return -1;
    }

}
