import java.util.*;
 
public class Main {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int n = scan.nextInt();
        int find = scan.nextInt();
        
        int[] nums = new int[n + 1];
        for(int i = 0; i < n; i++) {
            nums[i] = scan.nextInt();
        }
        
        int min = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;
        int sum = 0;
        
        while(start <= n && end <= n) {
            if(sum >= find) {
                min = Math.min(min,end - start);
            }
            
            if(sum < find) sum += nums[end++];
            else sum -= nums[start++];
        }
        
        if(min == Integer.MAX_VALUE) System.out.println(0);
        else System.out.println(min);
    }
}    
