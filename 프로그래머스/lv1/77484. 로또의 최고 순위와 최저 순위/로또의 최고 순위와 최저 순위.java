import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        
        Arrays.sort(lottos);
        Arrays.sort(win_nums);
        
        List<Integer> winLotto = Arrays.stream(win_nums).boxed().collect(Collectors.toList());
        
        int zero = 0;
        int win = 0;
        
        for(int i = 0; i < 6; i++){
            if(lottos[i] == 0){
                zero++;
            }
            else if(winLotto.contains(lottos[i])){
                win++;
            }
        }
        
        answer[0] = rank(win + zero);
        answer[1] = rank(win);
        
        return answer;
    }
    
    public int rank(int score){
        if(score == 6){
            return 1;
        }
        if(score == 5){
            return 2;
        }
        if(score == 4){
            return 3;
        }
        if(score == 3){
            return 4;
        }
        if(score == 2){
            return 5;
        }
        else{
            return 6;
        }
    }
}