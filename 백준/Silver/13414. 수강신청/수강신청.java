import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        String[] A = new String[n];

        for (int i = 0; i < n; i++) {
            A[i] = br.readLine();
        }

        LinkedHashSet<String> set = new LinkedHashSet<>();
        for(String item : A){
            if(set.contains(item)){
                set.remove(item);
            }
            set.add(item);
        }

        int temp = 0;

        for(String answer : set){
            temp++;
            System.out.println(answer);
            if(temp == k) break;
        }
    }
}
