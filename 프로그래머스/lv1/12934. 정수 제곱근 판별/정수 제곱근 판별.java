class Solution {
    public long solution(long n) {
        long answer = 0;
        double num = Math.sqrt(n);
        return Math.floor(num) == num? (long)Math.pow(num + 1, 2) : -1L;
    }
}