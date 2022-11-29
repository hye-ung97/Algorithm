import java.io.*;
import java.util.Arrays;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split(" ");
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(str[i]);
        }

        Stack<Integer> stack = new Stack<>();
        int[] answer = new int[n];

        stack.push(0);
        for (int i = 1; i < num.length; i++) {
            while (!stack.isEmpty() && num[stack.peek()] < num[i]){
                answer[stack.pop()] = num[i];
            }
            stack.push(i);
        }

        while (!stack.isEmpty()){
            answer[stack.pop()] = -1;
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < answer.length; i++) {
            bw.write(answer[i]+" ");
        }

        bw.flush();
        bw.close();
    }
}
