class Solution {
    public static int[] answer;
    public int[] solution(int[][] arr) {
        answer = new int[2];
        divide(arr, 0, 0, arr.length);
        return answer;
    }
    
    public static void divide(int[][] arr, int a, int b, int size){

        if(check(arr, a, b, size)){
            answer[arr[a][b]]++;
            return;
        }

        divide(arr, a, b, size /2); // 1
        divide(arr, a, b + size / 2, size / 2 ); // 2
        divide(arr, a + size / 2, b, size / 2 ); // 3
        divide(arr, a + size / 2, b + size / 2, size / 2 ); // 4
    }

    public static boolean check(int[][]arr, int a, int b, int size){
        for (int i = a; i < a + size ; i++) {
            for (int j = b; j < b +size ; j++) {
                if(arr[a][b] != arr[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
}