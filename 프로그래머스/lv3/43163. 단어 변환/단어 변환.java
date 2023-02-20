import java.util.ArrayList;

public class Solution {

    public static int count;
    public static boolean[] visited;
    
    public static int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        count = Integer.MAX_VALUE;

        ArrayList<String> list = new ArrayList<>();
        for(String item : words){
            list.add(item);
        }

        if(list.contains(target)){
            find(begin, target, words, 0);
            return count;
        }
        else{
            return 0;
        }
    }

    public static void find(String start, String target, String[] words, int cnt){
        if(start.equals(target)){
            count = Math.min(count, cnt);
            return;
        }

        for (int i = 0; i < words.length; i++) {
            if(visited[i]){
                continue;
            }

            int temp = 0;
            for (int j = 0; j < words[i].length() ; j++) {
                if(words[i].charAt(j) == start.charAt(j)){
                    temp++;
                }
            }

            if(temp == words[i].length() - 1){
                visited[i] = true;
                find(words[i], target, words, cnt + 1);
                visited[i] = false;
            }
        }
    }
}
