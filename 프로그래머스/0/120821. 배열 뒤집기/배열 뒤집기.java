import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.IntStream;

class Solution {
    public int[] solution(int[] num_list) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(IntStream.of(num_list).boxed().toArray(Integer[]::new)));
        Collections.reverse(list);
        return Arrays.stream(list.toArray(new Integer[0])).mapToInt(i -> i).toArray();
    }
}