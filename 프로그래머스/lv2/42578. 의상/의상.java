import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> type = new HashMap<>();
        for(String[] temp : clothes){
            type.put(temp[1], type.getOrDefault(temp[1], 1) + 1);
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        
        for(String temp : type.keySet()){
            int num = type.get(temp);
            list.add(num);
        }
        
        int join = 1;
        
        for(int temp : list){
            join *= temp;
        }
        
        
        return join - 1;
    }
}