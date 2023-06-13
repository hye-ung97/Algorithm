import java.util.*;

class Solution {
    public int[] solution(String msg) {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            list.add(String.valueOf((char) ('A' + i)));
        }

        ArrayList<Integer> result = new ArrayList<>();
        int idx = 0;

        while (idx + 1 < msg.length()){
            String cur = "";
            String pre = String.valueOf(msg.charAt(idx));

            for (int i = 1; idx + i <= msg.length() ; i++) {
                cur = msg.substring(idx, idx + i);
                if(!list.contains(cur)){
                    list.add(cur);
                    break;
                }
                pre = cur;
            }

            result.add(list.indexOf(pre));
            idx = idx + pre.length();
        }

        if(idx == msg.length() - 1){
            result.add(list.indexOf(String.valueOf(msg.charAt(idx))));
        }
        
        return result.stream().mapToInt(i -> i + 1).toArray();
    }
}