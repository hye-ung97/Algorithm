import java.util.*;

class Solution {
    public static String[] alphabet = {"A", "E", "I", "O", "U"};
    public static ArrayList<String> words = new ArrayList<>();
    public static int solution(String word) {
        int answer = 0;

        dfs("", 0);
        //Collections.sort(words);
        answer = words.indexOf(word);

        return answer;
    }

    public static void dfs(String word, int depth){
        words.add(word);
        if(5 == depth)    return;

        for (int i = 0; i < alphabet.length; i++) {
            dfs(word + alphabet[i], depth + 1);
        }
    }
}