class Solution {
    public String solution(String[] id_pw, String[][] db) {
        String answer = "fail";
        
        for(String[] cur : db){
            if(cur[0].equals(id_pw[0])){
                if(cur[1].equals(id_pw[1])){
                    return "login";
                }
                else{
                    return "wrong pw";
                }
            }
        }
        
        return answer;
    }
}