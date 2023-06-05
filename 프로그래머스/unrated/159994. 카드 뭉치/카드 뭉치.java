import java.util.*;
class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        Queue<String> c1 = new LinkedList();
        for(String str : cards1){
            c1.add(str);
        }
        
        Queue<String> c2 = new LinkedList();
        for(String str : cards2){
            c2.add(str);
        }
        
        for(int i = 0; i < goal.length; i++){
            if(goal[i].equals(c1.peek())){
                c1.poll();
            }
            else if(goal[i].equals(c2.peek())){
                c2.poll();
            }
            else {
                return "No";
            }
        }
        
        return "Yes";
    }
}