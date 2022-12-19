import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        PriorityQueue<Integer> plus = new PriorityQueue<>((x1, x2) -> x2-x1);
        PriorityQueue<Integer> mi = new PriorityQueue<>((x1, x2) -> x2-x1);
        for (int i = 0; i < n; i++) {
            int temp = sc.nextInt();
            if(temp > 0){
                plus.add(temp);
            }
            else{
                mi.add(Math.abs(temp));
            }
        }

        int max = 0;
        if(plus.isEmpty()){
            max = mi.peek();
        }
        else if(mi.isEmpty()){
            max = plus.peek();
        }
        else{
            max = Math.max(plus.peek(),mi.peek());
        }

        int result = 0;

        while (!plus.isEmpty()){
            result += plus.poll() * 2;
            for (int i = 0; i < m-1; i++) {
                plus.poll();
                if(plus.isEmpty()){
                    break;
                }
            }
        }

        while (!mi.isEmpty()){
            result += mi.poll() * 2;
            for (int i = 0; i < m-1; i++) {
                mi.poll();
                if(mi.isEmpty()){
                    break;
                }
            }
        }

        result = result - max;

        System.out.println(result);

    }
}
