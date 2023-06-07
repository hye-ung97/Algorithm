class Solution {
    public int solution(int[][] sizes) {
        int h = 0, v = 0;
        
        for(int i = 0; i < sizes.length; i++){
            int max = Math.max(sizes[i][0], sizes[i][1]);
            int min = Math.min(sizes[i][0], sizes[i][1]);
            
            h = Math.max(h, max);
            v = Math.max(v, min);
        }
        
        return h * v;
    }
}