import java.util.*;

class Solution {
    private String needsToString(int[] needs) {
        StringBuilder sb = new StringBuilder();
        for (int n : needs) {
            sb.append(n).append(',');
        }
        return sb.toString();
    }
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        Map<String, Integer> memo = new HashMap<>();
        int[] needsArray = new int[needs.size()];
        for (int i = 0; i < needs.size(); i++) {
            needsArray[i] = needs.get(i);
        }
        return dfs(needsArray, price, special, memo);
    }
    private int dfs(int[] needs, List<Integer> price, List<List<Integer>> special, Map<String, Integer> memo) {
        String needsStr = needsToString(needs);
        if (memo.containsKey(needsStr)) {
            return memo.get(needsStr);
        }
        boolean isDone = true;
        for (int n : needs) {
            if (n > 0) {
                isDone = false;
                break;
            }
        }
        if (isDone) {
            return 0;
        }
        int minCost = 0;
        for (int i = 0; i < needs.length; i++) {
            minCost += needs[i] * price.get(i);
        }
        for (List<Integer> offer : special) {
            int[] newNeeds = Arrays.copyOf(needs, needs.length);
            boolean validOffer = true;
            for (int i = 0; i < needs.length; i++) {
                newNeeds[i] -= offer.get(i);
                if (newNeeds[i] < 0) {
                    validOffer = false;
                    break;
                }
            }
            if (validOffer) {
                minCost = Math.min(minCost, offer.get(needs.length) + dfs(newNeeds, price, special, memo));
            }
        }
        memo.put(needsStr, minCost);
        return minCost;
    }
}