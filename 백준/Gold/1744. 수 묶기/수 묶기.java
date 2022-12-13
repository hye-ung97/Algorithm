import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    static PriorityQueue<Integer> plusQ;
    static PriorityQueue<Integer> minusQ;

    public static int Qsum(PriorityQueue<Integer> queue){
        int sum = 0;
        while (!queue.isEmpty()){
            if(queue.size() == 1)   break;

            int a = queue.poll();
            int b = queue.poll();

            sum = sum + (a * b);
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        plusQ = new PriorityQueue<>(Collections.reverseOrder());
        minusQ = new PriorityQueue<>();

        int one = 0;
        int zero = 0;

        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();
            if(num > 1){
                plusQ.offer(num);
            }
            else if(num < 0){
                minusQ.offer(num);
            }
            else if(num == 0){
                zero++;
            }
            else if(num == 1){
                one ++;
            }
        }

        int sum = Qsum(plusQ) + Qsum(minusQ);

        if(plusQ.size() != 0){
            sum = sum + plusQ.poll();
        }

        if(minusQ.size() != 0){
            if(zero > 0){
                minusQ.poll();
                zero--;
            }
            else{
                sum = sum + minusQ.poll();
            }
        }

        for (int i = 0; i < one; i++) {
            sum = sum + 1;
        }

        System.out.println(sum);

    }
}
