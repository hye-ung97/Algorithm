import java.util.HashMap;
class Solution {
    public static char[][] map;
    public static HashMap<String, int[]> diMap;
    public static int[] cur;
    public int[] solution(String[] park, String[] routes) {
        cur = new int[2];
        map = new char[park.length][park[0].length()];

        for (int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[i].length(); j++) {
                map[i][j] = park[i].charAt(j);
                if(map[i][j] == 'S'){
                    cur[0] = i;
                    cur[1] = j;
                }
            }
        }

        diMap = new HashMap<>();
        diMap.put("E", new int[]{0,1});
        diMap.put("W", new int[]{0,-1});
        diMap.put("S", new int[]{1,0});
        diMap.put("N", new int[]{-1,0});

        for(String temp : routes){
            String di = temp.split(" ")[0];
            int step = Integer.parseInt(temp.split(" ")[1]);
            find(di, step);
        }
        return cur;
    }

    public static void find(String di, int step){
        int x = cur[1];
        int y = cur[0];

        for (int i = 0; i < step; i++) {
            int[] d = diMap.get(di);
            x += d[1];
            y += d[0];

            if(x >=0 && y >= 0 && x < map[0].length && y < map.length){
                if(map[y][x] == 'X'){
                    return;
                }
            }
            else{
                return;
            }
        }
        cur[0] = y;
        cur[1] = x;
    }
}