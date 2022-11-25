class Solution {
    public int solution(int n) {
        
        String str = Integer.toBinaryString(n);
        int cnt = 0 ;
        char[] arr = str.toCharArray();

        for(char item : arr){
            if(item == '1'){
                cnt ++;
            }
        }
        
        while (true){
            n++;
            String tmp = Integer.toBinaryString(n);
            char[] arr2 = tmp.toCharArray();
            int cnt2 = 0 ;
            for(char item : arr2){
                if(item == '1'){
                    cnt2 ++;
                }
            }
            if(cnt==cnt2){
                break;
            }
        }
        
        return n;
    }
}