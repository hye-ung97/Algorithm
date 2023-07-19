import java.util.*;
class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = enemy.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < enemy.length; i++) {
            n = n - enemy[i];
            pq.add(enemy[i]);

            if(n < 0) {
                if(k > 0) {
                    n = n + pq.poll();
                    k--;
                    continue;
                }
                answer = i;
                break;
            }
        }
        return answer;
    }
}