import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] answer = new int[3];
        int[] one = {1,2,3,4,5};
        int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        for(int i = 0; i < answers.length; i++){
            if(one[i % 5] == answers[i]){
                answer[0]++;
            }
            if(two[i % two.length] == answers[i]){
                answer[1]++;
            }
            if(three[i % three.length] == answers[i]){
                answer[2]++;
            }
        }
        
        int max = Arrays.stream(answer).max().getAsInt();
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < answer.length;i++){
            if(max == answer[i]){
                list.add(i + 1);
            }
        }
        
        int[] result = new int[list.size()];
        for(int i = 0; i < result.length; i++){
            result[i] = list.get(i);
        }
        
        return result;
    }
}