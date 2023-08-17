import java.util.*;
class Solution {
    public int[] solution(int[] fees, String[] records) {
        int stdTime = fees[0];
        int stdFee = fees[1];
        int addTime = fees[2];
        int addFee = fees[3];

        HashMap<String, Integer> input = new HashMap<>();
        HashMap<String, Integer> out = new HashMap<>();

        for (int i = 0; i < records.length; i++) {
            String[] temp = records[i].split(" ");
            int m = time(temp[0]);
            if(temp[2].equals("IN")){
                input.put(temp[1], m);
            }
            else{
                int diff = m - input.get(temp[1]);
                input.remove(temp[1]);
                out.put(temp[1], out.getOrDefault(temp[1], 0) + diff);
            }
        }

        int end = time("23:59");
        for(String time : input.keySet()){
            int diff = end - input.get(time);
            out.put(time, out.getOrDefault(time, 0) + diff);
        }

        ArrayList<String> numbers = new ArrayList<>();
        for(String num : out.keySet()){
            numbers.add(num);
        }
        Collections.sort(numbers);

        int[] answer = new int[numbers.size()];

        for (int i = 0; i < numbers.size(); i++) {
            int cur = out.get(numbers.get(i));
            int fee = 0;
            if(cur > stdTime){
                cur = cur - stdTime;
                double t = Math.ceil((double) cur / addTime);
                fee = (int) t * addFee;
            }
            answer[i] = stdFee + fee;
        }
        return answer;
    }

    public static int time(String timestamp){
        int hours = Integer.parseInt(timestamp.split(":")[0]) * 60;
        int minute = Integer.parseInt(timestamp.split(":")[1]);
        return hours + minute;
    }
}