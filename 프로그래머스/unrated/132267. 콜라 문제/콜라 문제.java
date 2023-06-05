class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        
        while(true){
            int remain = n % a;
            int bottle = n / a * b;
            answer = answer +  bottle;
            n = remain + bottle;
            if(n < a){
                break;
            }
        }
        return answer;
    }
}