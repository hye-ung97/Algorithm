import java.util.*;

public class Solution {
    public static int[] solution(String[] gems){

        int[] answer = new int[2];

        HashSet<String> set = new HashSet<>();
        for(String item : gems){
            set.add(item);
        }

        HashMap<String, Integer> map = new HashMap<>();

        int start = 0;
        int idx = 0;
        int dist = Integer.MAX_VALUE;
        Queue<String> queue = new LinkedList<>();

        for (int i = 0; i < gems.length; i++) {
            map.put(gems[i], map.getOrDefault(gems[i], 0) + 1);

            queue.add(gems[i]);

            while (true){ // 중복 연속 제거
                if(map.get(queue.peek()) <= 1){
                    break;
                }
                map.put(queue.peek(), map.get(queue.peek()) - 1);
                queue.poll();
                idx++;
            }

            if(map.size() == set.size() && dist > i - idx){
                dist = i - idx;
                start = idx + 1;
            }
        }

        answer = new int[]{start, start + dist};

        return answer;
    }
}
