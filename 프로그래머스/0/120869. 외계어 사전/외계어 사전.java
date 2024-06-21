import java.util.ArrayList;
import java.util.Arrays;
class Solution {
    public int solution(String[] spell, String[] dic) {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < dic.length; i++) {
            char[] chars = dic[i].toCharArray();
            Arrays.sort(chars);
            list.add(String.valueOf(chars));
        }

        StringBuffer spellStr = new StringBuffer();
        for (String a : spell) {
            spellStr.append(a);
        }
        char[] spellChars = spellStr.toString().toCharArray();
        Arrays.sort(spellChars);
        String spellStrSorted = String.valueOf(spellChars);

        return list.contains(spellStrSorted) ? 1 : 2;
    }
}