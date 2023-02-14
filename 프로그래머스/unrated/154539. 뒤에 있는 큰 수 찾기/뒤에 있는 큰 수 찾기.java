import java.util.Arrays;
import java.util.Stack;

public class Solution {

    public static int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];

        Arrays.fill(answer, -1);
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < numbers.length; i++) {
            while (!stack.isEmpty() && numbers[i] > numbers[stack.peek()]){
                int idx = stack.pop();
                answer[idx] = numbers[i];
            }
            stack.push(i);
        }

        return answer;
    }
}
