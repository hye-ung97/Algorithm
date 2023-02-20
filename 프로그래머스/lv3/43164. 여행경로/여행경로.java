import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class Solution {

    public static ArrayList <tripTicket> list;
    public static boolean[] visited;
    public static PriorityQueue<String> pq = new PriorityQueue<>();
    public static class tripTicket implements Comparable<tripTicket>{
        int no;
        String from;
        String to;

        public tripTicket(int no, String from, String to) {
            this.no = no;
            this.from = from;
            this.to = to;
        }

        @Override
        public int compareTo(tripTicket o) {
            if(this.from.equals(o.from)){
                return this.to.compareTo(o.to);
            }
            return this.from.compareTo(o.from);
        }
    }
    public static String[] solution(String[][] tickets) {
        list = new ArrayList<>();
        for (int i = 0; i < tickets.length; i++) {
            list.add(new tripTicket(i, tickets[i][0], tickets[i][1]));
        }

        Collections.sort(list);
        visited = new boolean[tickets.length];

        BFS("ICN", tickets, 0, "ICN");
        String[] answer = pq.poll().split(" ");

        return answer;
    }

    public static void BFS(String start, String[][] tickets, int cnt, String road){
        if(cnt == tickets.length){
            pq.add(road);
            return;
        }

        for(tripTicket item : list){
            if(!visited[item.no] && item.from.equals(start)){
                visited[item.no] = true;
                BFS(item.to, tickets, cnt + 1, road + " " + item.to);
                visited[item.no] = false;
            }
        }
    }
}
