class Solution {
    public int solution(int[] nums) {
        int answer = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    answer = check(sum) == true? answer + 1 : answer;
                }
            }
        }

        return answer;
    }
    
    public static boolean check(int sum){
        for (int i = 2; i < sum / 2; i++) {
            if(sum % i == 0){
                return false;
            }
        }
        return true;
    }
}