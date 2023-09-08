class Solution {
    public static char[] ch;
    public int solution(String s) {

        ch = s.toCharArray();
        
        for (int len = s.length(); len > 1; len--) {

            for (int start = 0; start + len <= s.length(); start++) {
                if(isPalindrome(start, len)){
                    return len;
                }
            }
        }

        return 1;
    }

    public static boolean isPalindrome(int start, int len){

        for (int i = 0; i < len /2; i++) {
            if (ch[start + i] != ch[start + len - i - 1]) {
                return false;
            }
        }
        return true;
    }
}