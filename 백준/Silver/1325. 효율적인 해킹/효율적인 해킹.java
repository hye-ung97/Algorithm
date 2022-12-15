import java.util.*;

public class Main {
    public static ArrayList<Integer>[] list;
    public static boolean[] visitied;
    public static int[] distance;

    public static void BFS(int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visitied[start] = true;

        while (!queue.isEmpty()){
            int cur = queue.poll();
            for(int item : list[cur]){
                if(!visitied[item]){
                    visitied[item] = true;
                    queue.add(item);
                    distance[item] ++;
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        list = new ArrayList[n+1];
        distance = new int[n+1];

        for (int i = 0; i < n+1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < k; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            list[a].add(b);
        }

        for (int i = 1; i <= n ; i++) {
            visitied = new boolean[n+1];
            BFS(i);
        }

        int max = Arrays.stream(distance).max().getAsInt();
        ArrayList<Integer> answer = new ArrayList<>();
        for (int i = 1; i < n+1; i++) {
            if(distance[i] == max){
                answer.add(i);
            }
        }

        Collections.sort(answer);
        for(int item : answer){
            System.out.print(item + " ");
        }
        System.out.println();

    }
}
