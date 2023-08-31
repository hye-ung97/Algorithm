class Solution {
    public int[] solution(String[] wallpaper) {
        int minx = Integer.MAX_VALUE;
        int miny = Integer.MAX_VALUE;
        int maxx = Integer.MIN_VALUE;
        int maxy = Integer.MIN_VALUE;
        
        for(int i = 0; i < wallpaper.length; i ++){
            for(int j = 0; j < wallpaper[i].length(); j ++ ){
                if(wallpaper[i].charAt(j) == '#'){
                    minx = Math.min(minx, i);
                    miny = Math.min(miny, j);
                    maxx = Math.max(maxx, i);
                    maxy = Math.max(maxy, j);
                }
            }
        }
        
        return new int[]{minx, miny, maxx + 1, maxy + 1};
    }
}