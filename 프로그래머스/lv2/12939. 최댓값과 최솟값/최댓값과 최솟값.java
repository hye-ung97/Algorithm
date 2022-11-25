import java.util.Arrays;
class Solution {
    public String solution(String s) {
        String[] str = s.split(" ");

        int[] number = new int[str.length];
        for (int i = 0; i < str.length; i++) {
            number[i] = Integer.parseInt(str[i]);
        }

        Integer max = Arrays.stream(number).max().getAsInt();
        Integer min = Arrays.stream(number).min().getAsInt();

        String answer = min + " " + max;
        
        return answer;
    }
}