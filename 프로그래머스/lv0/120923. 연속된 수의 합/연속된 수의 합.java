class Solution {
    public int[] solution(int num, int total) {
        int[] answer = new int[num];
        int sum = 0;
        int cnt = 0 ;

        while (true){

            for (int i = cnt; i < cnt + num; i++) {
                sum += i;
            }
            if(sum < total){
                cnt++;
            }
            else if (sum > total){
                if(cnt <= -1){
                    cnt--;
                }
                else if(cnt >= 0){
                    cnt = -1;
                }
            }
            else if(sum == total){
                break;
            }
            sum = 0;
        }
        
        for(int i=0; i < num; i++){
            answer[i] = cnt + i;
        }
        
        return answer;
    }
}