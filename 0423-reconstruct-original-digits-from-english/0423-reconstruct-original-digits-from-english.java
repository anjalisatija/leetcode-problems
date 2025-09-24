class Solution {
    public String originalDigits(String s) {
        int[] count = new int[10]; // Array to store the count of each digit
        for (char ch : s.toCharArray()) {
            // Count the occurrences of unique characters for each digit
            if (ch == 'z') count[0]++; // 'z' is only present in "zero"
            if (ch == 'w') count[2]++; // 'w' is only present in "two"
            if (ch == 'u') count[4]++; // 'u' is only present in "four"
            if (ch == 'x') count[6]++; // 'x' is only present in "six"
            if (ch == 'g') count[8]++; // 'g' is only present in "eight"
            if (ch == 'o') count[1]++; // 'o' is present in "zero", "one", "two", "four"
            if (ch == 'h') count[3]++; // 'h' is present in "three", "eight"
            if (ch == 'f') count[5]++; // 'f' is present in "four", "five"
            if (ch == 's') count[7]++; // 's' is present in "six", "seven"
            if (ch == 'i') count[9]++; // 'i' is present in "five", "six", "eight", "nine"
        }
        
        // Update the counts based on the occurrences of characters
        count[1] -= (count[0] + count[2] + count[4]);
        count[3] -= count[8];
        count[5] -= count[4];
        count[7] -= count[6];
        count[9] -= (count[5] + count[6] + count[8]);
        
        // Construct the result string
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < count[i]; j++) {
                result.append(i);
            }
        }
        return result.toString();
    }
}