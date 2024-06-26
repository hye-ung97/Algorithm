import java.util.Arrays;
import java.util.HashMap;
class Solution {
    public String solution(String rsp) {
        StringBuffer sb = new StringBuffer();
        HashMap<String, String> rspMap = new HashMap<>();
        rspMap.put("2", "0");// 가위
        rspMap.put("0", "5");// 바위
        rspMap.put("5", "2");// 보
        String[] rspArr = rsp.split("");
        Arrays.stream(rspArr).map(rspMap::get).forEach(sb::append);
        return sb.toString();
    }
}