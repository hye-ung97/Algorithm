import java.util.*;

class Solution {
    public static char[] card;
    public static boolean[] visited;
    public static HashSet<Integer> set;
    public int solution(String numbers) {
        
        visited = new boolean[numbers.length()];
        card = numbers.toCharArray();
        set = new HashSet<>();
        dfs(0, "");
        return set.size();
    }
    
    public static void dfs(int depth, String num){
        if(depth == visited.length){
            if(num.equals("")){
                return;
            }
            int temp = Integer.parseInt(num);
            if(isPrime(temp)){
                set.add(temp);
            }
            return;
        }

        for (int i = 0; i < card.length; i++) {
            if(!visited[i]){
                visited[i] = true;
                dfs(depth + 1, num + card[i]);
                visited[i] = false;
                dfs(depth + 1, num);
            }
        }
    }
    
    public static boolean isPrime(int n){
        if(n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }
}