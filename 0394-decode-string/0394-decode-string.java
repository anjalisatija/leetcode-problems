/**
 * 394. Decode String
* Given an encoded string, return its decoded string.
 *
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated
 * exactly k times. Note that k is guaranteed to be a positive integer.
 *
 * You may assume that the input string is always valid; there are no extra white spaces, square brackets are
 * well-formed, etc. Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].
 *
 * The test cases are generated so that the length of the output will never exceed 10^5.
 *
 * Constraints:
 * 1 <= s.length <= 30
 * s consists of lowercase English letters, digits, and square brackets '[]'.
 * s is guaranteed to be a valid input.
 * All the integers in s are in the range [1, 300].
 *
 */
/*
The encoding rule is stated as k[encoded_string]. To be more precise, it's actually k[encoded_string] | encoded_string.
That is, the top-level surrounding k[ ] is optional. For example, "abc" and "a1[b]c" are valid.
	  
Time: O(k * n), where k is the maximum repeat and n is the length of s
Space: O(n), where n is the length of s (stack space for recursive calls)
*/
public class Solution  {
    int pos;

    public String decodeString(final String s) {
        final StringBuilder sb = new StringBuilder();
        final int n = s.length();
        for (; pos < n; pos++) {  // O(n) time
            char ch = s.charAt(pos);
            if (ch == ']') {
                break;  // base case
            } else if (ch >= 'a' && ch <= 'z') {
                sb.append(ch);
            } else if (ch >= '0' && ch <= '9') {
                int k = 0;
                do {
                    k = 10 * k + ch - '0';
                    ch = s.charAt(++pos);
                } while (ch >= '0' && ch <= '9');
                pos++; // consumes left bracket
                String decoded = decodeString(s); // O(n) space for recursive call stack
                while (k-- > 0) {  // O(k) time
                    sb.append(decoded);
                }
            } else {
                throw new RuntimeException("unexpected character: " + ch);
            }
        }
        return sb.toString();
    }
}