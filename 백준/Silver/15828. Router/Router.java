import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int buffersize = sc.nextInt();
        Deque deque = new ArrayDeque();

        while (true){
            int input = sc.nextInt();
            if(input == -1){
                break;
            }

            if(deque.size()<buffersize && input !=0){
                deque.addLast(input);
            }
            else if(input == 0){
                deque.pollFirst();
            }
        }

        if(deque.isEmpty()){
            System.out.println("empty");
        }
        else{
            while (!deque.isEmpty()){
                System.out.print(deque.pollFirst() + " ");
            }
        }
    }
}
