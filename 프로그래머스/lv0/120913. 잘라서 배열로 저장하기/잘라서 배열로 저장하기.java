class Solution {
    public String[] solution(String my_str, int n) {
        
        int arrLen = 0;

        if(my_str.length() % n ==0){
            arrLen = my_str.length() / n;
        }
        else{
            arrLen = my_str.length() / n + 1;
        }
        
        String[] result = new String[arrLen];

        int len = 0;
        int i=0;

        while (true){
            if(len == my_str.length()){
                break;
            }
            if(len+n > my_str.length()){
                result[i] = my_str.substring(len, my_str.length());
                break;
            }
            result[i] = my_str.substring(len, len+n);
            i++;
            len = len + n;
        }
        
        return result;
    }
}