import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int item : nums){
            map.put(item, map.getOrDefault(item, 0) + 1);
        }
        
        return map.size() < (nums.length / 2)? map.size() : (nums.length / 2);
    }
}