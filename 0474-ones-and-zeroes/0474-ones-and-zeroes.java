class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        return helper(strs, m, n, 0);
    }
    
    public int helper(String[] strs, int zeros, int ones, int index){
        if(index == strs.length || zeros + ones == 0) return 0;
        int[] count = count(strs[index]);
        int consider = 0;
        if(zeros >= count[0] && ones >= count[1]) consider = 1 + helper(strs, zeros-count[0], ones-count[1], index+1);
        int skip = helper(strs, zeros, ones, index+1);
        return Math.max(consider, skip);
    }
    
    public int[] count(String s){
        int[] counts = new int[2];
        for(char c : s.toCharArray()){
            counts[c-'0']++;
        }
        return counts;
    }
}