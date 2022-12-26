class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        char[] arr = t.toCharArray();
        Long num = Long.valueOf(p);
        int gap = p.length();

        int left = 0;
        int right = left + gap - 1;

        while (right < t.length()){
            StringBuffer sb = new StringBuffer();
            for (int i = left; i <= right ; i++) {
                sb.append(arr[i]);
            }
            if(Long.parseLong(sb.toString()) <= num){
                answer++;
            }
            left++;
            right++;
        }

        return answer;
    }
}