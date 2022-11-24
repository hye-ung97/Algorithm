class Solution {
    public int solution(int n) {
        int x = 2;
        
        while (x<=n){
            if(n%x ==1){
                break;
            }
            x++;
        }
        
        return x;
    }
}