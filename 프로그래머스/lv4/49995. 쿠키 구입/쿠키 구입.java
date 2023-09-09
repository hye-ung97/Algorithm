class Solution {
    public int solution(int[] cookie) {
        int answer = 0;
        
        for (int m = 1; m < cookie.length; m++) {
            int i = m - 1;
            int r = m;
            int left = cookie[i];
            int right = cookie[r];

            while (true) {
                if (left == right) {
                    answer = Math.max(answer, left);
                }

                if (left <= right && i > 0) {
                    i --;
                    left += cookie[i];
                } else if (left >= right && r < cookie.length - 1) {
                    r ++;
                    right += cookie[r];
                } else break;
            }
        }
        
        return answer;
    }
}