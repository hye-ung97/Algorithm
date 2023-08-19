class Solution {
    public String solution(int n) {
        String[] numbers = {"4", "1", "2"};
        String answer = "";

        int num = n;

        while(num > 0){
          int temp = num % 3;
          num /= 3;

          if(temp == 0) num--;

          answer = numbers[temp] + answer;
        }

        return answer;
    }
}