import java.util.*;
class Solution
{
    public int solution(int [][]board)
    {
        int answer = 0;
        
        answer = Arrays.stream(board).flatMapToInt(Arrays::stream).max().getAsInt();
        if(answer == 0){
            return 0;
        }

        for (int i = 1; i < board.length; i++) {
            for (int j = 1; j < board[0].length; j++) {
                if(board[i][j] == 1){
                    int min = Math.min(Math.min(board[i-1][j], board[i][j - 1]), board[i - 1][j - 1]);
                    board[i][j] = min + 1;
                    answer = Math.max(answer, board[i][j]);
                }
            }
        }

        return answer * answer;
    }
}