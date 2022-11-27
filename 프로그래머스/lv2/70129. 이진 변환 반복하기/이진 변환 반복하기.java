class Solution {
    public int[] solution(String s) {
        int zero =0;
        int cnt =0 ;

        int[] answer = new int[2];

        while (!s.equals("1")){
            cnt++;
            String tmp = "";
            for (String str : s.split("")){
                if(str.equals("0")){
                    zero++;
                }
                else{
                    tmp = tmp+str;
                }
            }
            int len = tmp.length();
            s = Integer.toBinaryString(len);
        }

        answer[0] = cnt;
        answer[1] = zero;
        return answer;
    }
}