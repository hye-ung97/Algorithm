import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        String[] nArr = new String[N];
        String[] mArr = new String[M];

        for (int i = 0; i < N; i++) {
            nArr[i] = sc.next();
        }
        for (int i = 0; i < M; i++) {
            mArr[i] = sc.next();
        }
       
        HashMap<String, String> map = new HashMap<>();
        for(String s : nArr){
            map.put(s, s);
        }

        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            if(map.containsKey(mArr[i])){
                list.add(map.get(mArr[i]));
            }
        }

        Collections.sort(list);

        System.out.println(list.size());
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
