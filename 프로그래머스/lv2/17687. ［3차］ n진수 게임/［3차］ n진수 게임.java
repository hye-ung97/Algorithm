import java.util.ArrayList;
class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder answer = new StringBuilder();
        ArrayList<String> nums = new ArrayList<>();

        for (int i = 0; i < t * m; i++) {
            String temp = Integer.toString(i, n);
            for(String item : temp.split("")){
                nums.add(item.toUpperCase());
            }
        }

        int start = 0;
        for (int i = 0; i < t; i++) {
            answer.append(nums.get(start + p - 1));
            start = start + m;
        }

        return answer.toString();
    }
}