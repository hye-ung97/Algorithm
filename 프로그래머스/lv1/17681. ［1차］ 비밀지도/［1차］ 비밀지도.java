import java.util.*;

class Solution {
    public static String Change(int num, int n){
        String temp = Integer.toString(num, 2);
        
        while(temp.length() < n){
            temp = "0" + temp;
        }
        return temp;
        
    }
    
    public String decode(String a, String b, int n){
        StringBuffer sb = new StringBuffer();
        
        for(int i = 0; i < n; i++){
            if(a.charAt(i) == '1' || b.charAt(i) == '1'){
                sb.append("#");
            }
            else{
                sb.append(" ");
            }
        }
        
        return sb.toString();
        
    }
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        ArrayList<String> a1 = new ArrayList<>();
        ArrayList<String> a2 = new ArrayList<>();
        
        for(int i = 0; i < arr1.length; i++){
            a1.add(Change(arr1[i], n));
            a2.add(Change(arr2[i], n));
        }
        
        for(int i = 0; i < arr1.length; i++){
            answer[i] = decode(a1.get(i), a2.get(i), n);
        }
        
        return answer;
    }
}