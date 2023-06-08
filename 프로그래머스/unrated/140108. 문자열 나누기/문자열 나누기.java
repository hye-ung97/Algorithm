class Solution {
    public int solution(String s) {
        int answer = 0;
        int a = 0, b = 0 ;
        char x = s.charAt(0);
        
        for(int i = 0; i < s.length(); i++){
            char cur = s.charAt(i);
            if(x == cur){
                a++;
            }
            else{
                b++;
            }
            
            if(a == b){
                answer++;
                a = 0;
                b = 0;
                if(i + 1 < s.length()){
                    x = s.charAt(i + 1);
                }
            }
            else if(i == s.length() - 1){
                answer++;
            }
            
        }
        return answer;
    }
}