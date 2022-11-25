import java.util.Stack;

class Solution {
    public String solution(String s) {
        String answer = "";
        
        Stack stack = new Stack();

        for(String item : s.split("")){
            if(stack.isEmpty() || stack.peek().equals(" ")){
                if('0' <= item.charAt(0) && item.charAt(0) <= '9'){
                    stack.push(item);
                }
                else{
                    stack.push(item.toUpperCase());
                }
            }
            else{
                stack.push(item.toLowerCase());
            }
        }

        while (!stack.isEmpty()){
            answer = stack.pop() + answer;
        }
        
        return answer;
    }
}