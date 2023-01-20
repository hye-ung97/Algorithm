import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Item implements Comparable<Item>{
        int idx;
        int weight;
        int cost;

        public Item(int idx, int weight, int cost) {
            this.idx = idx;
            this.weight = weight;
            this.cost = cost;
        }

        @Override
        public int compareTo(Item o) {
            if(this.weight == o.weight){
                return o.cost - this.cost;
            }
            return this.weight - o.weight;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());//보석수
        int K = Integer.parseInt(st.nextToken());//가방수

        Item[] item = new Item[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            item[i] = new Item(i, w, c);
        }

        int[] bag = new int[K];
        for (int i = 0; i < K; i++) {
            bag[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(item);
        Arrays.sort(bag);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        long result = 0;

        for (int i = 0, j = 0; i < K; i++) {
            while (j < N && item[j].weight <= bag[i]) {
                pq.offer(item[j++].cost);
            }

            if (!pq.isEmpty()) {
                result += pq.poll();
            }
        }

        System.out.println(result);

    }
}
