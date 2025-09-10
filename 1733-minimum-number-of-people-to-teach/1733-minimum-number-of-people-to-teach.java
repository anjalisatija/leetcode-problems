import java.util.*;

class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        int m = languages.length;
        List<Set<Integer>> langs = new ArrayList<>();
        for (int[] l : languages) {
            Set<Integer> set = new HashSet<>();
            for (int lang : l) set.add(lang);
            langs.add(set);
        }
        Set<Integer> badUsers = new HashSet<>();
        for (int[] f : friendships) {
            int u = f[0] - 1;
            int v = f[1] - 1;
            Set<Integer> setU = langs.get(u);
            Set<Integer> setV = langs.get(v);
            boolean common = false;
            for (int lang : setU) {
                if (setV.contains(lang)) {
                    common = true;
                    break;
                }
            }
            if (!common) {
                badUsers.add(u);
                badUsers.add(v);
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int lang = 1; lang <= n; lang++) {
            int count = 0;
            for (int user : badUsers) {
                if (!langs.get(user).contains(lang)) {
                    count++;
                }
            }
            ans = Math.min(ans, count);
        }
        return ans;
    }
}