import java.util.*;

public class Main {
    public static ArrayList<Integer>[] list;
    public static int[] distance;
    public static boolean[] visitied;

    public static void BFS(int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visitied[start] = true;

        while (!queue.isEmpty()){
            int cur = queue.poll();
            for (int item : list[cur]) {
                if(!visitied[item]){
                    distance[item] = distance[cur] + 1;
                    visitied[item] = true;
                    queue.add(item);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int d = sc.nextInt();
        int k = sc.nextInt();
        int start = sc.nextInt();

        list = new ArrayList[n+1];
        for (int i = 0; i < n+1; i++) {
            list[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < d; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            list[a].add(b);
        }

        distance = new int[n+1];
        visitied = new boolean[n+1];

        BFS(start);

        ArrayList<Integer> answer = new ArrayList<>();
        for (int i = 0; i < distance.length; i++) {
            if(distance[i] == k){
                answer.add(i);
            }
        }

        if(answer.isEmpty()){
            System.out.println(-1);
        }
        else{
            Collections.sort(answer);
            for(int item : answer){
                System.out.println(item);
            }
        }



    }
}
