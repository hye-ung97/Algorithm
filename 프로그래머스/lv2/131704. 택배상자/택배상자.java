import java.util.*;
class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();

        for (int i = 1; i <= order.length; i++) {
            q.add(i);
        }

        for(int cur : order){
            if(!stack.isEmpty() && stack.peek() == cur){
                stack.pop();
                answer++;
            }
            else {
                boolean flag = false;
                while (!q.isEmpty()){
                    if(q.peek() == cur){
                        answer++;
                        q.poll();
                        flag = true;
                        break;
                    }
                    else{
                        stack.add(q.poll());
                    }
                }
                if(!flag){
                    break;
                }
            }
        }
        return answer;
    }
}