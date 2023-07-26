class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int stationIdx = 0;	
        int cur = 1;	
        
        while(cur <= n) {	
            
            if(stationIdx < stations.length && cur >= stations[stationIdx] - w) {
                
                cur = stations[stationIdx] + w + 1;	
                stationIdx ++;	
            }
            else {
                answer += 1;	
                cur += (w*2) + 1;
            }
        }
        return answer;
    }
}