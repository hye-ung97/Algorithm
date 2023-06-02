import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        if(arr.length == 1){
            return new int[]{-1};
        }
        
        int min = Arrays.stream(arr).min().getAsInt();
        ArrayList<Integer> list = new ArrayList<>();
        for(int data : arr){
            if(data == min){
                continue;
            }
            list.add(data);
        }
        
        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}