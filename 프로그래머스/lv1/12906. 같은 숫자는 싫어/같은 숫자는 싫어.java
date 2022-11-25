import java.util.*;
import java.util.Stack;

public class Solution {
    public int[] solution(int []arr) {
        Stack stack = new Stack();

        for (int i = 0; i < arr.length; i++) {
            if(!stack.isEmpty() && (int) stack.peek() == arr[i]){
                continue;
            }
            stack.push(arr[i]);
        }

        int[] answer = new int[stack.size()];
        int idx = stack.size()-1;
        while (!stack.isEmpty()){
            answer[idx--] = (int)stack.pop();
        }

        return answer;
    }
}