class Pair {
    String op;
    int time;

    Pair(String op, int time) {
        this.op = op;
        this.time = time;
    }
}

public class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Pair> stack = new Stack<>();
        int[] result = new int[n];

        for (String log: logs) {
            String[] logInfo = log.split(":");
            int fId = Integer.parseInt(logInfo[0]);
            String operation = logInfo[1];
            int time = Integer.parseInt(logInfo[2]);

            if (operation.equals("start")) {
                stack.push(new Pair(operation, time));
                continue;
            }

            int otherFuncTime = 0;
            while (!stack.isEmpty() && !stack.peek().op.equals("start")) {
                otherFuncTime += stack.pop().time;
            }

            int currenFuncTime = (time - stack.pop().time + 1) - otherFuncTime;
            result[fId] += currenFuncTime;
            stack.push(new Pair("totalTime", currenFuncTime + otherFuncTime));
        }

        return result;
    }
}