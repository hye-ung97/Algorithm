class Solution {
    public String solution(int n) {
        String str1 = "수박";
        String str2 = "수";
        StringBuffer sb = new StringBuffer();

        int str1N = n / 2;
        int str2N = n % 2;

        for (int i = 0; i < str1N; i++) {
            sb.append(str1);
        }
        for (int i = 0; i < str2N; i++) {
            sb.append(str2);
        }

        return sb.toString();
    }
}