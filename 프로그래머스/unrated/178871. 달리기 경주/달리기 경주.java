import java.util.*;
class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = new String[players.length];
        HashMap<String, Integer> runner = new HashMap<>();
        for (int i = 0; i < players.length; i++) {
            runner.put(players[i], i);
            answer[i] = players[i];
        }

        for (int i = 0; i < callings.length; i++) {
            String cur = callings[i];
            int idx = runner.get(cur);
            String pre = answer[idx - 1];

            runner.put(cur, idx - 1);
            runner.put(pre, idx);

            answer[idx] = pre;
            answer[idx - 1] = cur;
        }
        
        return answer;
    }
}