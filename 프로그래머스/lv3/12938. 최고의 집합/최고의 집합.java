class Solution {
    public int[] solution(int n, int s) {
        if(n > s){
            return new int[]{-1};
        }

        int num = s / n;
        int remain = s % n;

        int[] answer = new int[n];

        for (int i = 0; i < n; i++) {
            answer[i] = num;
        }

        for (int i = 0; i < remain; i++) {
            answer[n - i - 1] = answer[n - i - 1] + 1;
        }
        return answer;
    }
}