class Solution {
    public String solution(int[] food) {
        String result = "";
        
        for (int i = 1; i < food.length; i++) {
            for (int j = 0; j < food[i] / 2; j++) {
                result +=Integer.toString(i);
            }
        }

        StringBuffer sb = new StringBuffer(result);
        sb = sb.reverse();

        result = result + "0" + sb;
        
        return result;
    }
}