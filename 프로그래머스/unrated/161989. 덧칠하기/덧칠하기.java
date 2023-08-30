import java.util.*;
class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int item : section){
            pq.add(item);
        }

        int cur = 0;
        while (!pq.isEmpty()){
            if(pq.peek() < cur){
                pq.poll();
                continue;
            }
            cur = pq.poll() + m;
            answer++;
        }
        return answer;
    }
}