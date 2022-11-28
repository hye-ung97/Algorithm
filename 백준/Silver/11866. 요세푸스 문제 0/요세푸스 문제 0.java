import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        Deque deque = new ArrayDeque();
        for (int i = 1; i < N+1; i++) {
            deque.addLast(i);
        }

        StringBuffer str = new StringBuffer();
        str.append("<");

        while (!deque.isEmpty()){
            for (int i = 0; i < K-1; i++) {
                if(deque.size()==1){
                    break;
                }
                if(!deque.isEmpty()){
                    int temp = (int)deque.pollFirst();
                    deque.addLast(temp);
                }
            }
            if(deque.size()==1){
                str.append(deque.pollFirst());
                continue;
            }
            str.append(deque.pollFirst() + ", ");
        }

        str.append(">");

        System.out.println(str);
    }
}
