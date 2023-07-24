import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {0,0};

        PriorityQueue<Integer> max = new PriorityQueue<>((o1, o2) -> o2 - o1);
        PriorityQueue<Integer> min = new PriorityQueue<>();

        for (int i = 0; i < operations.length; i++) {
            String[] temp = operations[i].split(" ");
            int num = Integer.parseInt(temp[1]);
            if(temp[0].equals("I")) {
                max.add(num);
                min.add(num);
            } else if (num == 1 && !max.isEmpty()) { // 최댓값 삭제
                int n = max.poll();
                min.remove(n);
            }
            else if(!max.isEmpty()){ // 최솟값 삭제
                int n = min.poll();
                max.remove(n);
            }
        }

        if(max.isEmpty() && min.isEmpty()){
            return answer;
        }
        answer[0] = max.poll();
        answer[1] = min.poll();

        return answer;
    }
}