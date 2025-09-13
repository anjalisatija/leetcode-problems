import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        return compute(expression, new HashMap<>());
    }

    private List<Integer> compute(String expression, Map<String, List<Integer>> memo) {
        // Check if the result for the expression is already computed
        if (memo.containsKey(expression)) {
            return memo.get(expression);
        }

        List<Integer> results = new ArrayList<>();
        boolean isNumber = true;

        // Check each character in the expression
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (ch == '+' || ch == '-' || ch == '*') {
                isNumber = false;
                // Split expression into left and right parts
                String left = expression.substring(0, i);
                String right = expression.substring(i + 1);
                
                // Compute all possible results for the left and right parts
                List<Integer> leftResults = compute(left, memo);
                List<Integer> rightResults = compute(right, memo);
                
                // Combine results
                for (int l : leftResults) {
                    for (int r : rightResults) {
                        if (ch == '+') {
                            results.add(l + r);
                        } else if (ch == '-') {
                            results.add(l - r);
                        } else if (ch == '*') {
                            results.add(l * r);
                        }
                    }
                }
            }
        }

        // If the expression is just a number, add it to results
        if (isNumber) {
            results.add(Integer.parseInt(expression));
        }

        // Store the computed results in memo
        memo.put(expression, results);
        return results;
    }
}