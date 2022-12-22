import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int deleteNum = sc.nextInt();
        String numStr = sc.next();

        char[] cArr = numStr.toCharArray();
        Deque<Character> deque = new ArrayDeque<>();
        deque.addLast(cArr[0]);
        int cnt = 0;
        for (int i = 1; i < cArr.length; i++) {
            while (deleteNum > 0 && !deque.isEmpty() && deque.peekLast() < cArr[i]){
                deque.pollLast();
                deleteNum--;
            }
            deque.addLast(cArr[i]);
        }

        StringBuffer sb = new StringBuffer();

        while (deque.size() > deleteNum){
            sb.append(deque.pollFirst());
        }
        System.out.println(sb.toString());
    }
}
