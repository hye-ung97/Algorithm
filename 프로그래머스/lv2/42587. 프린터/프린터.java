import java.util.LinkedList;
import java.util.Queue;

class Doc{
    int index;
    int priority;

    public Doc(int index, int priority) {
        this.index = index;
        this.priority = priority;
    }
}

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Doc> queue = new LinkedList<>();

        for (int i = 0; i < priorities.length; i++) {
            queue.add(new Doc(i, priorities[i]));
        }

        int cnt = 1;
        while (true){
            Doc cur = queue.poll();
            Doc[] tmp = queue.stream().filter(x -> x.priority > cur.priority).toArray(Doc[]::new);

            if(tmp.length > 0){
                queue.add(cur);
                continue;
            }

            if(cur.index == location){
                answer = cnt;
                break;
            }
            cnt++;

        }
        return answer;
    }
}