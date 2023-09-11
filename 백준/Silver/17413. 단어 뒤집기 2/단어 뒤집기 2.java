import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        StringBuilder tag = new StringBuilder();
        boolean flag = false;

        for(int i = 0; i < input.length(); i++){
            char item = input.charAt(i);
            if(item == '>'){
                flag = false;
                tag.append(item);
                sb.append(tag);
                tag = new StringBuilder();
            }
            else if(item == '<' || flag){
                flag = true;
                tag.append(item);
            }
            else if(item == ' '){
                while (!stack.isEmpty()){
                    sb.append(stack.pop());
                }
                sb.append(" ");
            }
            else if (i + 1 < input.length() && input.charAt(i + 1) == '<') {
                sb.append(item);
                while (!stack.isEmpty()){
                    sb.append(stack.pop());
                }
            }
            else{
                stack.add(item);
            }
        }

        if(!stack.isEmpty()){
            while (!stack.isEmpty()){
                sb.append(stack.pop());
            }
        }
        System.out.println(sb.toString());
    }
}
