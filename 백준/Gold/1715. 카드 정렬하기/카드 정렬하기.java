import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        PriorityQueue<Integer> card = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            card.add(sc.nextInt());
        }

        int cnt = 0;
        while (!card.isEmpty()&& card.size()>1){
            int a = card.poll();
            int b = card.poll();

            cnt = cnt + a + b;
            if(card.isEmpty()){
                break;
            }
            card.add(a + b);
        }

        System.out.println(cnt);
    }
}
