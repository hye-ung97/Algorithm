import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        Arrays.sort(tangerine);
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int item : tangerine){
            if(map.containsKey(item)){
                map.put(item, map.get(item) + 1);
            }else {
                map.put(item, 1);
            }
        }
        ArrayList<Integer> list = new ArrayList<>(map.values());
        Collections.sort(list, Collections.reverseOrder());
        int cnt = 0;
        for (int i = 0; i < list.size(); i++) {
            if(k <= 0){
                break;
            }
            k = k - list.get(i);
            cnt++;
        }

        return cnt;
    }
}