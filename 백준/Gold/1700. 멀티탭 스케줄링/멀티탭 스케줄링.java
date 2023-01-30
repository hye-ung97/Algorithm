import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] items = new int[K];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            int a = Integer.parseInt(st.nextToken());
            items[i] = a;
        }

        boolean[] used = new boolean[items.length + 1];

        int idx = 0;
        int cnt = 0;
        while (cnt < N) {
            if (!used[items[idx]]) {
                used[items[idx]] = true;
                cnt++;
            }
            idx++;
        }

        int result = 0;
        while (idx < items.length) {
            if (!used[items[idx]]) {
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = idx; i < items.length; i++) {
                    if (used[items[i]] && !list.contains(items[i])) {
                        list.add(items[i]);
                    }
                }

                if (list.size() == N) {
                    used[list.get(N - 1)] = false;
                } else {
                    for (int j = 1; j <= items.length; j++) {
                        if (used[j] && !list.contains(j)) {
                            used[j] = false;
                            break;
                        }
                    }
                }
                used[items[idx]] = true;
                result++;
            }
            idx++;
        }
        System.out.println(result);
    }
}
