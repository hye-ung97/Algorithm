class Solution {
    boolean solution(String s) {
        boolean answer = true;
        s = s.toLowerCase();

        int p = 0;
        int y = 0;
        
        for(char ch : s.toCharArray()){
            if(ch == 'p'){
                p++;
            }
            else if(ch == 'y'){
                y++;
            }
        }

        return p == y? true : false;
    }
}