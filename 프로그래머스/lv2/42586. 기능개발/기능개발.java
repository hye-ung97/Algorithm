import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] time = new int[progresses.length];
        Queue queue = new LinkedList();
        ArrayList<Integer> list = new ArrayList();

        for (int i = 0; i < progresses.length; i++) {
            time[i] = (int)Math.ceil((double) (100 - progresses[i]) / speeds[i]);
            queue.add(time[i]);
        }

        int index = 0;
        int cnt = 1;
        while (!queue.isEmpty()){
            int cur = (int) queue.poll();
            list.add(index, cnt);
            while (true){
                if(!queue.isEmpty() && (int)queue.peek() <= cur){
                    queue.poll();
                    cnt++;
                    list.remove(index);
                    list.add(index,cnt);
                }
                else{
                    index++;
                    cnt = 1;
                    break;
                }
            }
        }
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}