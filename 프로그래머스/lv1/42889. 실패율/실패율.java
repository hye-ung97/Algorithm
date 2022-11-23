import java.util.Arrays;
class Solution {
    public int[] solution(int N, int[] stage) {
        
        int[] stageCnt = new int[N+1];
        int[] stagePersongSum = new int[N+1];

        double[][] result = new double[N][2];

        for (int i = 1; i <=stage.length ; i++) {
            stageCnt[stage[i-1]-1]+=1;
        }

        for (int i = stagePersongSum.length-1; i > -1; i--) {
            if(i==stagePersongSum.length-1){
                stagePersongSum[i] = stageCnt[i];
            }
            else{
                stagePersongSum[i] = stagePersongSum[i+1] + stageCnt[i];
            }
        }

        for (int i = 0; i < result.length; i++) {
            if(stageCnt[i] == 0){
                result[i][1] = 0;
            }
            else{
                result[i][1] = (double) stageCnt[i] / stagePersongSum[i];
            }
            result[i][0] = i+1;
        }

        Arrays.sort(result,(o1, o2) -> {
            if(o1[1]==o2[1]){
                return Double.compare(o1[0], o2[0]);
            }
            else{
                return Double.compare(o2[1], o1[1]);
            }
        });

        int[] answer = new int[result.length];
        for (int i = 0; i < result.length; i++) {
            answer[i] = (int)result[i][0];
        }
        
        return answer;
    }
}