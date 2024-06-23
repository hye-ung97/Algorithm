import java.util.*;
import java.util.stream.IntStream;

class Solution {
    public int[] solution(int n, int[] numlist) {
        ArrayList<Integer> answerList = new ArrayList<>();
        IntStream.of(numlist).forEach(num -> {
            if (num % n == 0) {
                answerList.add(num);
            }
        });
        return answerList.stream().mapToInt(i -> i).toArray();
    }
}