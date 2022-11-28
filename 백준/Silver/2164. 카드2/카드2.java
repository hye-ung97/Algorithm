import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        Deque deque = new ArrayDeque();
        for (int i = 1; i < N+1; i++) {
            deque.addLast(i);
        }

        while (deque.size()>1){
            deque.pollFirst();
            int temp = (int)deque.pollFirst();
            deque.addLast(temp);
        }

        System.out.println(deque.poll());
    }
}
