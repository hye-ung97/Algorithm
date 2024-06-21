import java.util.HashMap;
import java.util.Map;

class Solution {
    public long solution(String numbers) {
        long answer = 0;
        String[] num = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < num.length; i++) {
            map.put(num[i], i);
        }
        while (!numbers.equals("")){
            for (String key : map.keySet()){
                if(numbers.startsWith(key)){
                    answer = answer * 10 + map.get(key);
                    numbers = numbers.substring(key.length());
                }
            }
        }
        return answer;
    }
}