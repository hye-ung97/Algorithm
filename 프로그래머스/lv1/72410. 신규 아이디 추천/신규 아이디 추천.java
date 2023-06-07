class Solution {
    public String solution(String new_id) {
        String answer = "";
        //1
        new_id = new_id.toLowerCase();
        //2
        StringBuffer temp = new StringBuffer();
        for(int i = 0; i < new_id.length(); i++){
            char cur = new_id.charAt(i);
            if((cur >= 'a' && cur <= 'z') || (cur >= '0' && cur <= '9') || cur == '-' || cur == '_' || cur == '.'){
                temp.append(cur);
            }
        }
        
        //3
        answer = temp.toString();
        while(answer.contains("..")){
            answer = answer.replace("..",".");
        }
        
        //4
        if(answer.startsWith(".")){
            answer = answer.substring(1);
        }
        if(answer.endsWith(".")){
            answer = answer.substring(0, answer.length()-1);
        }
        
        //5
        if(answer.length() <= 0){
            answer = "a";
        }
        
        //6
        if(answer.length() >= 16){
            answer = answer.substring(0, 15);
        }
        if(answer.endsWith(".")){
            answer = answer.substring(0, answer.length()-1);
        }
        
        //7
        if(answer.length() <= 2){
            while(answer.length() < 3){
                answer += answer.charAt(answer.length()-1);
            }
        }
        
        return answer;
    }
}