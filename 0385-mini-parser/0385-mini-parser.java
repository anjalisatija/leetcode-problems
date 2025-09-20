/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    public NestedInteger deserialize(String s) {
        //return parse(s.toCharArray, 0, s.length());
        if (isNumeric(s.charAt(0))) {
            return new NestedInteger(parseInteger(s, 0)[1]);
        }
        return parse(s.toCharArray());
    }

    // Enter here with start and end exceed the positions of [ and ] respectively
    private NestedInteger parse(char[] chars) {
        Stack<NestedInteger> stack = new Stack<NestedInteger>();        
        int pos = 0;
        NestedInteger container = null;
        NestedInteger current = null;
        stack.push(container);
        while (pos < chars.length) {
            char c = chars[pos];
            if (c == '[') {
                NestedInteger ni = new NestedInteger();
                stack.push(current);
                if (current == null) {
                    container = ni;
                } else {
                    current.add(ni);
                }
                current = ni;
                pos ++;
            } else if (c == ']') {
                current = stack.pop();
                pos++;
            } else if (isNumeric(c)) {
                int[] pair = parseInteger(chars, pos);
                current.add(new NestedInteger(pair[1]));
                pos = pair[0];
            } else if (c == ',') {
                pos++;
            }
        }
        return container;
    }

    private boolean isNumeric(char c) {
        return c == '-' || (c <= '9' && c >= '0');
    }

    private int[] parseInteger(String s, int start) {
        int i = start+1;
        while (i < s.length() && isNumeric(s.charAt(i))) {
            i++;
        }
        return new int[] { i, Integer.parseInt(s.substring(start, i)) };
    }

    private int[] parseInteger(char[] chars, int start) {
        int i = start+1;
        while (i < chars.length && isNumeric(chars[i])) {
            i++;
        }
        int accumulator = 0;
        int inx = start;
        if (chars[start] == '-') {
            inx ++;
        }        
        for (; inx < i; inx++) {
            accumulator = accumulator * 10 + (chars[inx] - '0');
        }
        if (chars[start] == '-') {
            accumulator *= -1;
        }
        return new int[] {i, accumulator};
    }

}