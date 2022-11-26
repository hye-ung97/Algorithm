import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    public String[] solution(String[] record) {
        HashMap<String, String> map = new HashMap<>();

        for (int i = 0; i < record.length; i++) {
            String[] str = record[i].split(" ");
            if(str[0].equals("Enter") || str[0].equals("Change")){
                map.put(str[1], str[2]);
            }
        }

        ArrayList<String> log = new ArrayList<>();
        for (int i = 0; i < record.length; i++) {
            String[] str = record[i].split(" ");
            if(str[0].equals("Enter")){
                String s = map.get(str[1])+"님이 들어왔습니다.";
                log.add(s);
            } else if (str[0].equals("Leave")) {
                String s = map.get(str[1])+"님이 나갔습니다.";
                log.add(s);
            }
        }

        String[] answer = new String[log.size()];
        for (int i = 0; i < log.size(); i++) {
            answer[i] = log.get(i);
        }
        return answer;
    }
}