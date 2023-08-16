import java.util.stream.IntStream;
import java.util.*;

class Solution {
    public int[] solution(String s) {
        String str = s.replace("{","");
        str = str.replace("},","/").replace("}","");
        String[] tuple = str.split("/");

        Arrays.sort(tuple, (o1, o2) -> o1.length() - o2.length());

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < tuple.length; i++) {
            String[] cur = tuple[i].split(",");

            for (int j = 0; j < cur.length; j++) {
                int num = Integer.parseInt(cur[j]);
                if(!list.contains(num)){
                    list.add(num);
                }
            }
        }

        return list.stream().flatMapToInt(i -> IntStream.of(i)).toArray();
    }
}