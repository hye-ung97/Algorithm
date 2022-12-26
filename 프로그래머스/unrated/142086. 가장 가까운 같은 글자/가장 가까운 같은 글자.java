import java.util.*;
class Solution {
    public int[] solution(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] arr = s.toCharArray();
        int[] answer = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            char temp = arr[i];
            if(map.containsKey(temp)){
                answer[i] = i - map.get(temp);
            }
            else{
                answer[i] = -1;
            }
            map.put(temp,i);
        }

        return answer;
    }
}