import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        ArrayList listlost = new ArrayList<>();
        for(int item : lost){
            listlost.add(item);
        }

        ArrayList listre = new ArrayList<>();
        for(int item : reserve){
            listre.add(item);
        }

        ArrayList same = new ArrayList<>();
        for (int i = 0; i < listlost.size(); i++) {
            if(listre.contains(listlost.get(i))){
                same.add(listlost.get(i));
            }
        }

        if(same.size() !=0){
            for (int i = 0; i < same.size(); i++) {
                listlost.remove(listlost.indexOf(same.get(i)));
                listre.remove(listre.indexOf(same.get(i)));
            }
        }

        int answer = n - listlost.size();

        for (int i = 0; i < listlost.size(); i++) {
            int find = (int)listlost.get(i);
            if(listre.contains(find-1)){
                listre.remove(listre.indexOf(find-1));
                answer++;
            }
            else if(listre.contains(find+1)){
                listre.remove(listre.indexOf(find+1));
                answer++;
            }
        }
        
        return answer;
    }
}