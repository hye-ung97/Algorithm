import java.util.*;
class Solution {
    public int[] solution(int brown, int yellow) {
        
        ArrayList list = new ArrayList();

        for (int i = 1; i <= yellow; i++) {
            if(yellow % i == 0){
                list.add(i);
            }
        }

        int[] answer = new int[2];
        for (int i = 0; i < list.size(); i++) {
            int wyellow = (int)list.get(i);
            int hyello = yellow / wyellow;

            int cnt = (wyellow + hyello) * 2 + 4;
            if(cnt == brown){
                answer[0] = wyellow+2 > hyello+2 ? wyellow+2 : hyello+2;
                answer[1] = wyellow+2 > hyello+2 ? hyello+2 : wyellow+2;
                break;
            }
        }
        
        return answer;
    }
}