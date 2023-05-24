import java.util.Arrays;

public class Solution {
    public static int solution(String dartResult) {
       int[] result = new int[3];
        int index = 0;
        int tmpIdx = 0;

        for(int i = 0; i < dartResult.length(); i++){
            char item = dartResult.charAt(i);
            if(Character.isDigit(item)){
                if(item == '1' && dartResult.charAt(i + 1) == '0'){
                    i++;
                    result[index] = 10;
                }
                else {
                    result[index] = Character.getNumericValue(item);
                }
                tmpIdx = index;
                index++;
            }
            switch (item){
                case 'D':
                    result[tmpIdx] = (int) Math.pow(result[tmpIdx], 2);
                    break;
                case 'T':
                    result[tmpIdx] = (int) Math.pow(result[tmpIdx], 3);
                    break;
                case '*':
                    result[tmpIdx] = result[tmpIdx] * 2;
                    if(tmpIdx != 0){
                        result[tmpIdx - 1] = result[tmpIdx - 1] * 2;
                    }
                    break;
                case '#':
                    result[tmpIdx] = result[tmpIdx] * -1;
                    break;
            }
        }
        
        int answer = Arrays.stream(result).sum();

        return answer;
    }

}
