import java.util.ArrayList;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;

        if(cacheSize == 0){
            return cities.length * 5;
        }

        ArrayList<String> lru = new ArrayList<>();

        for(String city : cities){
            city = city.toLowerCase();

            if(lru.contains(city)){
                answer++;
                lru.remove(city);
                lru.add(city);
            } else{
                if(lru.size() == cacheSize){
                    lru.remove(0);
                }
                answer = answer + 5;
                lru.add(city);
            }
        }
        return answer;
    }
}