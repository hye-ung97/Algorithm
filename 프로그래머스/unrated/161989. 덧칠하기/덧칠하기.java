import java.util.*;
class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int item : section){
            pq.add(item);
        }

        while (!pq.isEmpty()){
            int cur = pq.poll() + m;
            while (!pq.isEmpty()){
                if(pq.peek() >= cur){
                    break;
                }
                pq.poll();
            }
            answer++;
        }
        return answer;
    }
}