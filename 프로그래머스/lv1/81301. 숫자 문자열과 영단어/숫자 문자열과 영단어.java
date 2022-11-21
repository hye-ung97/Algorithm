import java.util.HashMap;
class Solution {
    public int solution(String s) {
        String answer = "";

        String[] numArr = {"zero","one", "two", "three", "four", "five","six", "seven", "eight", "nine"};
        HashMap<String, String> number = new HashMap<>();

        for (int i = 0; i < numArr.length; i++) {
            String n = Integer.toString(i);
            number.put(numArr[i],n);
            number.put(n, n);
        }

        int start = 0;

        for (int i = 0; i < s.length(); i++) {
            String s1 = s.substring(start,i+1);
            if(number.containsKey(s1)){
                answer+=number.get(s1);
                start = i+1;
            }
        }

        int result = Integer.valueOf(answer);
        
        return result;
    }
}