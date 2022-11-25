import java.util.Stack;
class Solution
{
    public int solution(String s)
    {
        int answer = -1;

        Stack stack = new Stack<>();
        char[] arr = s.toCharArray();

        for (int i = 0; i < s.length(); i++) {
            if(!stack.isEmpty() && ((char) stack.peek() == arr[i])){
                stack.pop();
                continue;
            }
            stack.push(arr[i]);
        }
        if(stack.isEmpty()){
            answer = 1;
        }
        else{
            answer =0;
        }

        return answer;
    }
}