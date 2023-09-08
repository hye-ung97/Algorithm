class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        int min = Math.min(n,m);
        int max = Math.max(n,m);
        
        answer[0] = gcd(min, max);
        answer[1] = n * m / answer[0];
        
        return answer;
    }
    
    public int gcd(int n, int m) {
        while(m > 0) {
            int r = n % m;
            n = m;
            m = r;
        }
        return n;
    }
}