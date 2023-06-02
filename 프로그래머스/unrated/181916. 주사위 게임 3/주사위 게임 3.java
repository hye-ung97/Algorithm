import java.util.*;

public class Solution {
    static class node implements Comparator<node> {
        int num;
        int cnt;

        public node(int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }

        @Override
        public int compare(node o1, node o2) {
            if(o1.cnt == o2.cnt){
                return o1.num - o2.num;
            }
            return o2.cnt - o1.cnt;
        }
    }
    public static int solution(int a, int b, int c, int d) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(a, map.getOrDefault(a, 0) + 1);
        map.put(b, map.getOrDefault(b, 0) + 1);
        map.put(c, map.getOrDefault(c, 0) + 1);
        map.put(d, map.getOrDefault(d, 0) + 1);

        ArrayList<node> list = new ArrayList<>();
        for(Integer key : map.keySet()){
            list.add(new node(key, map.get(key)));
        }

        if(list.size() == 1){
            return list.get(0).num * 1111;
        }
        else if(list.size() == 4){
            return list.get(0).num;
        }
        else if(list.size() == 3){ // 2 1 1
            int temp = 1;
            for (int i = 0; i < list.size(); i++) {
                if(list.get(i).cnt == 1){
                    temp = temp * list.get(i).num;
                }
            }
            return temp;
        }
        else{
            if(list.get(0).cnt == 2){
                return (list.get(0).num + list.get(1).num) * Math.abs(list.get(0).num - list.get(1).num);
            }
            else{ // 3 1
                if(list.get(0).cnt == 3){
                    return (int) Math.pow(10 * list.get(0).num + list.get(1).num,2);
                }
                else{
                    return (int) Math.pow(10 * list.get(1).num + list.get(0).num,2);
                }
            }
        }
    }
}
