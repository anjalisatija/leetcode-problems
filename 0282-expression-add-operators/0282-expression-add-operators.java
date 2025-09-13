import java.util.*;

public class Solution{
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        backtrack(result, num, target, 0, "", 0, 0);
        return result;
    }

    private static void backtrack(List<String> result, String num, int target, int index, String path, long calc, long tail) {
        if (index == num.length()) {
            if (calc == target) {
                result.add(path);
            }
            return;
        }

        for (int i = index; i < num.length(); i++) {
            if (i != index && num.charAt(index) == '0')
                break; // skip numbers with leading zeros
            String currentStr = num.substring(index, i + 1);
            long currentNum = Long.parseLong(currentStr);

            if (index == 0) {
                // first number, no operator
                backtrack(result, num, target, i + 1, currentStr, currentNum, currentNum);
            } else {
                // '+'
                backtrack(result, num, target, i + 1, path + "+" + currentStr, calc + currentNum, currentNum);

                // '-'
                backtrack(result, num, target, i + 1, path + "-" + currentStr, calc - currentNum, -currentNum);

                // '*'
                backtrack(result, num, target, i + 1, path + "*" + currentStr, calc - tail + tail * currentNum,
                        tail * currentNum);
            }
        }
    }

    
}