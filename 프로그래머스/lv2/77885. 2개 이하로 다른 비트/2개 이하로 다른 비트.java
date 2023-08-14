class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            long num = numbers[i];

            if(num % 2 == 0){
                answer[i] = num + 1;
            }
            else{
                String numTo2 = Long.toBinaryString(num);
                if(numTo2.contains("0")){
                    int idx = numTo2.lastIndexOf("0");
                    numTo2 = numTo2.substring(0, idx) + "10" + numTo2.substring(idx + 2);
                }
                else{
                    numTo2 = "10" + numTo2.substring(1);
                }
                answer[i] = Long.parseLong(numTo2, 2);
            }
        }
        return answer;
    }
}