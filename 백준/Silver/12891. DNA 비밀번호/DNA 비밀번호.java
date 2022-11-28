import java.util.Scanner;

public class Main {

    static int[] mincheck ;//최소 문자열 개수
    static int[] checkarr ;//현재 배열 상태
    static int checkstr;


    public static void Add(char a){
        if(a == 'A'){
            checkarr[0] ++;
            if(mincheck[0]==checkarr[0]){
                checkstr++;
            }
        } else if (a == 'C') {
            checkarr[1] ++;
            if(mincheck[1]==checkarr[1]){
                checkstr++;
            }
        }
        else if(a=='G'){
            checkarr[2] ++;
            if(mincheck[2]==checkarr[2]){
                checkstr++;
            }
        }
        else if(a == 'T'){
            checkarr[3] ++;
            if(mincheck[3]==checkarr[3]){
                checkstr++;
            }
        }
    }

    public static void remove(char a){
        if(a == 'A'){
            if(mincheck[0]==checkarr[0]){
                checkstr--;
            }
            checkarr[0] --;
        } else if (a == 'C') {
            if(mincheck[1]==checkarr[1]){
                checkstr--;
            }
            checkarr[1] --;
        }
        else if(a=='G'){
            if(mincheck[2]==checkarr[2]){
                checkstr--;
            }
            checkarr[2] --;
        }
        else if(a == 'T'){
            if(mincheck[3]==checkarr[3]){
                checkstr--;
            }
            checkarr[3] --;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int totalLen = sc.nextInt();
        int sublen = sc.nextInt();
        String dna = sc.next();
        mincheck = new int[4];
        checkarr = new int[4];
        checkstr = 0 ;
        for (int i = 0; i < 4; i++) {
            mincheck[i] = sc.nextInt();
            if(mincheck[i]==0)  checkstr++;
        }

        int result = 0;

        char[] dnaArr = dna.toCharArray();

        for (int i = 0; i < sublen; i++) {
            Add(dnaArr[i]);
        }
        if(checkstr==4) result++;

        for (int i = sublen; i < dnaArr.length; i++) {
            int front = i - sublen;
            Add(dnaArr[i]);
            remove(dnaArr[front]);
            if(checkstr==4){
                result++;
            }
        }

        System.out.println(result);

    }
}
