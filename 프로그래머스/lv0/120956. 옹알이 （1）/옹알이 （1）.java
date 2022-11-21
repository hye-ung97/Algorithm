class Solution {
    public int solution(String[] babbling) {
        String[] can = {"aya", "ye", "woo", "ma"};
        
        int result = 0;

        for (int i = 0; i < babbling.length; i++) {
            for (int j = 0; j < can.length; j++) {
                if(babbling[i].contains(can[j])){
                    babbling[i] = babbling[i].replace(can[j]," ");
                }
            }
            babbling[i] = babbling[i].replace(" ","");
            if(babbling[i].length() == 0){
                result++;
            }
        }
        
        return result;
    }
}