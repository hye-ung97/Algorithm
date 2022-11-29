import java.util.ArrayList;
class Solution {
    public int[] solution(int n, String[] words) {
        
        ArrayList list = new ArrayList<String>();
        int[] answer = {0,0};

        for (int i = 0; i < words.length; i++) {
            if(list.contains(words[i])){
                answer[0] = (i % n) + 1;
                answer[1] = (i / n) + 1;
                break;
            }
            else if(list.size()>0 && list.get(i-1).toString().charAt(words[i-1].length()-1) != words[i].charAt(0)){
                answer[0] = (i % n) + 1;
                answer[1] = (i / n) + 1;
                break;
            }
            list.add(words[i]);

        }

        return answer;
    }
}