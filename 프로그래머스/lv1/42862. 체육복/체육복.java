import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;

        HashSet<Integer> reserveSet = new HashSet<>();
        for (int item : reserve) {
            reserveSet.add(item);
        }

        HashSet<Integer> lostSet = new HashSet<>();
        for (int item : lost) {
            if(reserveSet.contains(item)){
                reserveSet.remove(item);
                answer++;
            }
            else{
                lostSet.add(item);
            }
        }

        for(Integer item : lostSet){
            if(reserveSet.contains(item-1)){
                reserveSet.remove(item-1);
                answer++;
            }
            else if(reserveSet.contains(item+1)){
                reserveSet.remove(item+1);
                answer++;
            }
        }
        
        return answer;
    }
}