import java.util.HashMap;
import java.util.Stack;
class Solution {
    public int solution(String str) {
        int answer = 0;
        
        HashMap<String, String> map = new HashMap();
        map.put("(", ")");
        map.put("{", "}");
        map.put("[", "]");

        for (int i = 0; i < str.length()-1; i++) {
            Stack<String > stack = new Stack();
            boolean flag = true;

            for(String s: str.split("")) {
                if (map.containsKey(s)) {
                    stack.push(s);
                } else if (map.containsValue(s)) {
                    if (stack.isEmpty()) {
                        flag = false;
                        break;
                    } else {
                        String cur = stack.pop();
                        if (!s.equals(map.get(cur))) {
                            flag = false;
                            break;
                        }
                    }
                }
            }

            if (flag && stack.isEmpty()) {
                answer++;
            }

            str = str.substring(1, str.length()) + str.charAt(0);
        }
        
        return answer;
    }
}