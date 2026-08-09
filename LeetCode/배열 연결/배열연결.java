class Solution {
    public int[] getConcatenation(int[] nums) {
        int[] result = new int[nums.length * 2];

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < nums.length; j++) {
                result[nums.length * i + j] = nums[j];
            }
        }

        return result;
    }
}

//class Solution {
//    public int[] getConcatenation(int[] nums) {
//        int n = nums.length;
//        int[] ans = new int[n * 2];
//
//        for (int i = 0; i < n; i++) {
//            ans[i] = nums[i];
//            ans[i + n] = nums[i];
//        }
//
//        return ans;
//    }
//}