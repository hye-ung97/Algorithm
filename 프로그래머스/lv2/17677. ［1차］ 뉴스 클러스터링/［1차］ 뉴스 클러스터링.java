/*
    (o)1. 영문자가 아니면 삭제
    2. 문자열 길이 2~1000
    (o)3. 두 글자식 끊어서 배열로 저장
    4. 교집합, 합집합 구하기
    5. 교집합/합집합 x 65536 -> 정수만 출력
*/
import java.util.*;
class Solution {     
    public int solution(String str1, String str2) {

        ArrayList<String> splitArr = new ArrayList<String>(); 
        ArrayList<String> splitArr2 = new ArrayList<String>(); 

        ArrayList<Map<String, Integer>> arrMap1 = new ArrayList<Map<String, Integer>>();
        ArrayList<Map<String, Integer>> arrMap2 = new ArrayList<Map<String, Integer>>(); 
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();   

        ArrayList<String> maxArr = new ArrayList<String>(); 
        ArrayList<String> maxArr2 = new ArrayList<String>(); 

        ArrayList<String> arr = new ArrayList<String>(); 
        ArrayList<String> arr2 = new ArrayList<String>(); 
        ArrayList<String> index = new ArrayList<String>();
        //String[] arrSet1, arrSet2;
        int answer = 0;

        /*
        1단계
        str1, str2를 영어만 뽑아낸다
        //2단계
        //두글자씩 끊어서 ArrayList에 담는다.
        */

        //1))두글자씩 끊어낸다
        splitArr = splitStr(str1);
        splitArr2 = splitStr(str2);

        for(int i = 0; i <splitArr.size(); i++){
            System.out.println("split="+splitArr.get(i));
        }
        //2))영어만 뽑아낸다.
        splitArr = checkNotEng(splitArr);
        splitArr2 = checkNotEng(splitArr2);

        //3))합집합구하기
        int getMax = getMax(splitArr, splitArr2);

        //4))교집합, 같은건 arr2에서 뺀다.?
        int getMinn=0;
        ArrayList<String> resultSplit = new ArrayList<String>();
        getMinn = checkMin(splitArr, splitArr2);


        System.out.println("gegegegMax="+(double)getMax);
        System.out.println("gegegegMin="+(double)getMinn);
        System.out.println("gegegeg0.0="+(double)getMinn/getMax);

        Double mm;
        if(getMinn != 0.0 && getMax != 0.0){
            mm = (double)getMinn/getMax;
        }else if(getMinn == 0.0 && getMax != 0.0){
            mm = 0.0;
        }else{
            mm = 1.0;
        }

        answer = (int) Math.floor(mm*65536);
        return answer;
  }


    //같은건 뺸다??, 교집합
    public int checkMin(ArrayList<String> arr, ArrayList<String> arr2){
        int min = 0;
         for(int i = 0; i <arr.size(); i++){
            for(int j = 0; j < arr2.size(); j++){
               // System.out.println("check:i="+i+"j="+j+"번//"+arr2.get(i));
                if(arr2.get(j)!= null && (arr.get(i)).equalsIgnoreCase(arr2.get(j))){
                   // System.out.println("removeVluae:"+arr2.get(j));
                    min+=1;
                    arr2.set(j, null);
                    break;
                }
            }
        }

        return min;
    }
    //두글자씩 자르기
    public ArrayList<String> splitStr(String str){
        ArrayList<String> arr = new ArrayList<String>(); 
        for(int i = 0; i < str.length()-1; i++){
            arr.add(str.substring(i,i+2));
        }
        return arr;
    }

    //영문자 아니면 x 영문자만 담기
    public ArrayList<String> checkNotEng(ArrayList<String> arr){
        ArrayList<String> returnValue = new ArrayList<String>();
        for(int i = 0; i <arr.size(); i++){
            System.out.println("tt="+arr.get(i).matches("^[a-zA-Z]*$"));
            if(arr.get(i).matches("^[a-zA-Z]*$")){
                returnValue.add(arr.get(i));
                System.out.println("ttAdd="+arr.get(i));
            }
        }
        return returnValue;
    }

    //영어만 뽑아내기
    public String checkStrEng(String str){
        String result="";
        for(int i = 0; i <str.length(); i++){
            if( 65 <=str.charAt(i) && str.charAt(i) <= 90 
              || 97 <= str.charAt(i) && str.charAt(i) <= 122){
                result+=str.charAt(i);
            }
        }
        return result;
    }

    public int getMax(ArrayList<String> arr, ArrayList<String> arr2){

        ArrayList<String> copyArr2 = new ArrayList<String>();
        copyArr2.addAll(arr2);
        int maxValue=0;
        for(int i = 0; i <arr.size(); i++){
            for(int j = 0; j <copyArr2.size(); j++){
                if(copyArr2.get(j)!=null && arr.get(i).equalsIgnoreCase(copyArr2.get(j))){
                    System.out.println("i="+arr.get(i)+"/j="+copyArr2.get(j));
                    maxValue+=1;
                    copyArr2.set(j, null);
                    break;
                }

            }
        }
        return (arr.size()-maxValue)+(arr2.size()-maxValue)+maxValue;
    }
}