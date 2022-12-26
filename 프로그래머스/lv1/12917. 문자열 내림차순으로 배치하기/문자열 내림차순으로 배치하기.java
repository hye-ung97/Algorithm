import java.util.Arrays;
class Solution {
    public String solution(String s) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        StringBuffer sb = new StringBuffer();
        for (int i = arr.length-1; i >=0 ; i--) {
            sb.append(arr[i]);
        }
        return sb.toString();
    }
}