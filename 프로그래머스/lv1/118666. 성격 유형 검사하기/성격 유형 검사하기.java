import java.util.*;
class Solution {
    public String solution(String[] survey, int[] choices) {
        StringBuffer answer = new StringBuffer();
        String[] type = {"RT", "CF", "JM", "AN"};

        HashMap<Integer, Integer> score = new HashMap<>();
        score.put(4, 0);
        for (int i = 1; i <= 3; i++) {
            score.put(4 - i, i);
            score.put(4 + i, i);
        }

        HashMap<String, Integer> board = new HashMap<>();
        for (int i = 0; i < survey.length; i++) {
            String[] temp = survey[i].split("");
            int a = score.get(choices[i]);
            if(choices[i] > 4){
                board.put(temp[1], board.getOrDefault(temp[1], 0) + a);
            }
            else{
                board.put(temp[0], board.getOrDefault(temp[0], 0) + a);
            }
        }

        for (int i = 0; i < 4; i++) {
            String[] temp = type[i].split("");
            int front = board.containsKey(temp[0])? board.get(temp[0]) : 0;
            int back = board.containsKey(temp[1])? board.get(temp[1]) : 0;

            answer.append(front >= back ? temp[0] : temp[1]);
        }
        
        return answer.toString();
    }
}