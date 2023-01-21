import java.util.HashSet;
class Solution {
    public int solution(int[] elements) {
        int len = elements.length;
        HashSet<Integer> sumSet = new HashSet<>();
        for(int item : elements){
            sumSet.add(item);
        }

        int start = 0;
        int end = 0;
        int k = 1;

        for (int i = k; i < len ; i++) {
            int sum = 0;
            start = 0;
            end = (start + i) % len;

            for (int j = start; j <= end ; j++) {
                sum += elements[j];
            }

            sumSet.add(sum);
            end = (end + 1) % len;

            for (int j = start + 1; j < len ; j++) {
                sum = sum - elements[j - 1];
                sum = sum + elements[end];
                sumSet.add(sum);
                end = (end + 1) % len;
            }
        }

        return sumSet.size();
    }
}