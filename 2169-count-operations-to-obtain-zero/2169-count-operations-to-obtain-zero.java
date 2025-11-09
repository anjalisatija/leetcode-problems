class Solution {
    public int countOperations(int num1, int num2) {
        if (num1 == 0 || num2 == 0) return 0;
        if (num1 >= num2) {
            int q = num1/num2;
            return q + countOperations(num1 - (q * num2), num2); 
        } else {
            int q = num2/num1;
            return q + countOperations(num1, num2 - (q * num1));
        }
    }
}