import java.util.Deque;
import java.util.ArrayDeque;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] daysToWait = new int[temperatures.length];
        Deque<Integer> indicesStack = new ArrayDeque<>();

        for (int day = temperatures.length - 1; day >= 0; day--) {
            while (!indicesStack.isEmpty() && temperatures[day] >= temperatures[indicesStack.peek()]) {
                indicesStack.pop();
            }
            if (!indicesStack.isEmpty()) {
                daysToWait[day] = indicesStack.peek() - day;
            }
            indicesStack.push(day);
        }

        return daysToWait;
    }
}