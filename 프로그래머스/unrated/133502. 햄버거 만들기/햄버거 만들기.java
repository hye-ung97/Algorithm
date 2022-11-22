import java.util.Stack;
class Solution {
    public int solution(int[] ingredient) {
        
        Stack<Integer> stack = new Stack();
        int answer = 0;

        for (int i = 0; i < ingredient.length; i++) {
            if (ingredient[i] == 1 && stack.size() >= 3) {
                int[] tmp = new int[3];
                int index = -1;

                for (int j = 3; j > 0; j--) {
                    if (stack.peek() == j) {
                        index++;
                        tmp[index] = stack.pop();
                    } else {
                        for (int k = index; k > -1; k--) {
                            stack.push(tmp[k]);
                        }
                        index = -1;
                        break;
                    }
                }

                if(index==2){
                    answer++;
                    continue;
                }

            }
            stack.push(ingredient[i]);
        }
        
        return answer;
    }
}