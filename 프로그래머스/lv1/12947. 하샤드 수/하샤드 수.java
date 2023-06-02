class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        int sum = 0;
        int n = x;
        while(n > 0){
            sum += n % 10;
            n = n / 10;
        }
        
        return x % sum == 0 ? true : false;
    }
}