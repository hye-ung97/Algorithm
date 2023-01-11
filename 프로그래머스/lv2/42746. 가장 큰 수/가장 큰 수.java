import java.util.Arrays;

class Solution {
    public String solution(int[] numbers) {
        
        int sum = Arrays.stream(numbers).sum();
        if(sum == 0){
            return "0";
        }
        
        StringBuilder sb = new StringBuilder();
        if(numbers.length == 1){
            sb.append(numbers[0]);
            return sb.toString();
        }

        Arrays.stream(numbers)
                .boxed()
                .sorted((x, y) -> {
                    int a = Integer.parseInt(String.valueOf(x) + String.valueOf(y));
                    int b = Integer.parseInt(String.valueOf(y) + String.valueOf(x));
                    return b - a;
                })
                .forEach(sb::append);

        return sb.toString();
    }
}