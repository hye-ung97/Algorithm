import java.util.ArrayList;
import java.util.Arrays;

public class Solution {

    public static int solution(int n, int[][] edge) {
        ArrayList<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < edge.length; i++) {
            graph[edge[i][0]].add(edge[i][1]);
            graph[edge[i][1]].add(edge[i][0]);
        }
        
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        dist[1] = 0;
        
        boolean[] visited = new boolean[n + 1];

        for (int i = 0; i < n; i++) {
            int minDist = Integer.MAX_VALUE;
            int curIdx = 0;
            for (int j = 1; j < n + 1; j++) {
                // 방문한적 없는 노드 중 거리 최소인 노드 선택
                if (!visited[j] && dist[j] < minDist) {
                    minDist = dist[j];
                    curIdx = j;
                }
            }

            visited[curIdx] = true;

            // 선택된 노드의 인접 노드 거리 갱신
            for (int j = 0; j < graph[curIdx].size(); j++) {
                int adjNode = graph[curIdx].get(j);
                // 기존 거리 값보다 현재 노드에서 해당 노드로 가는 길의 거리 값이 더 작으면 업데이트
                if (dist[adjNode] > dist[curIdx] + 1) {
                    dist[adjNode] = dist[curIdx] + 1;
                }
            }
        }

        ArrayList<Integer> list = new ArrayList<>();

        int max = 0;
        for (int i = 1; i < dist.length ; i++) {
            if(dist[i] != Integer.MAX_VALUE)
                max = Math.max(dist[i], max);
        }

        for (int i = 1; i < dist.length; i++) {
            if(dist[i] == max){
                list.add(i);
            }
        }

        return list.size();
    }

    
}
