import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {

    public static class box{
        int len;
        int start;
        int end;

        public box(int len, int start, int end) {
            this.len = len;
            this.start = start;
            this.end = end;
        }
    }

    public int[] solution(int[] sequence, int k) {
        int[] answer = {0, sequence.length-1};
        PriorityQueue<box> pq = new PriorityQueue<>(new Comparator<box>() {
            @Override
            public int compare(box o1, box o2) {
                if(o1.len == o2.len){
                    return o1.start - o2.start;
                }
                return o1.len - o2.len;
            }
        });

        int start = 0;
        int end = start + 1;
        int sum = sequence[start];

        while (start < end){
            if(sum == k){
                pq.add(new box(end - start, start, end - 1));
                sum -= sequence[start++];
            }
            else if(sum > k){
                sum -= sequence[start++];
            }
            else if(end < sequence.length){
                sum += sequence[end++];
            }
            else{
                break;
            }
        }
        answer[0] = pq.peek().start;
        answer[1] = pq.peek().end;
        return answer;
    }
}
