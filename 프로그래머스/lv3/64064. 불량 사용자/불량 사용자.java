import java.util.*;
import java.util.regex.Pattern;
class Solution {
    public static HashSet<HashSet<String>> result;
    public static ArrayList<ArrayList<String>> bannedUserList;

    public int solution(String[] user_id, String[] banned_id) {
        result = new HashSet<HashSet<String>>();
        bannedUserList = new ArrayList<ArrayList<String>>();

        for (String bannedId : banned_id) {
            bannedUserList.add(getMatchesId(bannedId, user_id));
        }

        dfs(new HashSet<String>(), 0);

        return result.size();
    }

    public static ArrayList<String> getMatchesId(String bannedId, String[] user_id) {
        // 불량 사용자 아이디 정규 표현식으로 변환
        // 정규 표현식에서 '.' = 임의의 문자열 1개
        String pattern = bannedId.replace('*', '.');

        ArrayList<String> valueList = new ArrayList<>();

        for (String userId : user_id) {
            // 정규 표현식 턴에 맞는 유저 아이디 담음
            if (Pattern.matches(pattern, userId))
                valueList.add(userId);
        }

        return valueList;
    }

    public static void dfs(HashSet<String> add, int depth) {
        if (depth == bannedUserList.size()) {
            result.add(new HashSet<>(add));
            return;
        }

        // depth번째에 들어갈 수 있는 아이디 목록에서 뽑음
        for (String userId : bannedUserList.get(depth)) {
            if (!add.contains(userId)) {
                add.add(userId);
                dfs(add, depth + 1);
                add.remove(userId);
            }
        }
    }
}