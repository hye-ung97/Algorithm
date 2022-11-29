import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        PriorityQueue <Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> {
            int first = Math.abs(o1);
            int second = Math.abs(o2);
            if(first==second){
                return o1 > o2? 1:-1;
            }
            else{
                return first - second;
            }
        });

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(bf.readLine());
            if(num == 0 ){
                if(priorityQueue.isEmpty()){
                    System.out.println("0");
                }
                else{
                    System.out.println(priorityQueue.poll());
                }
            }
            else{
                priorityQueue.add(num);
            }
        }
    }
}
