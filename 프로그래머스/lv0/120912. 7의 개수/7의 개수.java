class Solution {
    public int solution(int[] array) {
        int answer = 0;
        
        for (int i = 0; i < array.length; i++) {
            int temp = array[i];
            while (true){
                if(temp == 0){
                    break;
                }
                if(temp % 10 == 7){
                    answer ++;
                }
                temp  = temp / 10;
            }
        }
        
        return answer;
    }
}