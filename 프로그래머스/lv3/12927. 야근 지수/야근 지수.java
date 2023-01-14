import java.util.*;
class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> y - x);
        for(int item : works){
            pq.add(item);
        }

        while (n > 0){
            int cur = pq.poll();
            if(cur <= 0){
                break;
            }
            pq.add(cur - 1);
            n--;
        }

        while (!pq.isEmpty()){
            answer += Math.pow(pq.poll(), 2);
        }

        return answer;
    }
}