import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public int solution(int[] people, int limit) {
        
        
        int cnt = 0;
        Deque deque = new LinkedList();
        Arrays.sort(people);
        for(int item : people){
            deque.addLast(item);
        }

        while (!deque.isEmpty()){
            int first = (int)deque.peekFirst();
            int end = (int)deque.peekLast();
            if(first + end <= limit){
                deque.pollLast();
                deque.pollFirst();
            }
            else{
                deque.pollLast();
            }
            cnt++;
        }
        
        return cnt;
    }
}