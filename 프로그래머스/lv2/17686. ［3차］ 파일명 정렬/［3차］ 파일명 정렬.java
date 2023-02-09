import java.util.ArrayList;
import java.util.Collections;

public class Solution {

    public static class file implements Comparable<file>{
        int idx;
        String head;
        String number;
        String footer;

        public file(int idx, String head, String number, String footer) {
            this.idx = idx;
            this.head = head;
            this.number = number;
            this.footer = footer;
        }

        @Override
        public int compareTo(file o) {
            String head1 = this.head.toLowerCase();
            String head2 = o.head.toLowerCase();

            int number1 = Integer.parseInt(this.number);
            int number2 = Integer.parseInt(o.number);

            if(head1.equals(head2)){
                if(number1 == number2){
                    return this.idx - o.idx;
                }
                else {
                    return number1 - number2;
                }
            }
            else{
                return head1.compareTo(head2);
            }
        }
    }

    public static file parsing (String str, int n){
        String head = "";
        String number = "";
        String footer = "";

        int idx = 0;

        while (true){
            if(str.charAt(idx) >= '0' && str.charAt(idx) <= '9'){
                break;
            }
            idx++;
        }

        head = str.substring(0, idx);

        int pre = idx;

        while (true){
            idx++;
            if(idx >= str.length() || str.charAt(idx) < '0' || str.charAt(idx) > '9'){
                break;
            }
        }

        number = str.substring(pre, idx);

        if(idx < str.length() - 1){
            footer = str.substring(idx);
        }

        return new file(n, head, number, footer);
    }

    public static String combine (file f){
        return f.head + f.number + f.footer;
    }

    public static String[] solution(String[] files) {
        String[] answer = new String[files.length];
        ArrayList<file> newFile = new ArrayList<>();

        for (int i = 0; i < files.length; i++) {
            file temp = parsing(files[i], i);
            newFile.add(temp);
        }

        Collections.sort(newFile);

        for (int i = 0; i < answer.length; i++) {
            answer[i] = combine(newFile.get(i));
        }

        return answer;
    }

}
