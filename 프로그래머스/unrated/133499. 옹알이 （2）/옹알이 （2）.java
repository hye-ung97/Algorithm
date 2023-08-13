class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        for (int i = 0; i < babbling.length; i++) {
            String cur = babbling[i];

            if(cur.contains("ayaaya") || cur.contains("yeye") || cur.contains("woowoo")||cur.contains("mama")){
                continue;
            }

            cur = cur.replace("aya", " ");
            cur = cur.replace("ye", " ");
            cur = cur.replace("woo", " ");
            cur = cur.replace("ma", " ");
            cur = cur.replace(" ", "");

            if(cur.isEmpty()){
                answer++;
            }
        }
        return answer;
    }
}