class Solution {
    public static boolean[] visited;
    public static int cnt;
    
    public int solution(int[] numbers, int target) {
        visited = new boolean[numbers.length];
        cnt = 0;

        search(numbers, target, 0);
        return cnt;
    }
    public static void search(int[] numbers, int target, int n){
        if(n == numbers.length ){
            int sum = 0;
            for (int i = 0; i < numbers.length; i++) {
                if(visited[i]){
                    sum = sum + numbers[i];
                }
                else{
                    sum = sum - numbers[i];
                }
            }
            if(sum == target){
                cnt = cnt + 1;
            }
            return;
        }

        visited[n] = true;
        search(numbers, target, n + 1);
        visited[n] = false;
        search(numbers, target, n + 1);
    }
}