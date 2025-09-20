import java.util.*;

class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            dfs(i, n, result);
        }
        return result;
    }

    private void dfs(int curr, int n, List<Integer> result) {
        if (curr > n) return;
        result.add(curr);

        for (int next = 0; next < 10; next++) {
            int newNum = curr * 10 + next;
            if (newNum > n) return;
            dfs(newNum, n, result);
        }
    }
}