class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int ans = 0;
        int min = arrays.get(0).get(0);
        int max = arrays.get(0).get(arrays.get(0).size() - 1);

        for (int i = 1; i < arrays.size(); i++) {
            var arr = arrays.get(i);
            int a = Math.abs(arr.get(0) - max);
            int b = Math.abs(arr.get(arr.size() - 1) - min);
            ans = Math.max(ans, Math.max(a, b));
            min = Math.min(min, arr.get(0));
            max = Math.max(max, arr.get(arr.size() - 1));
        }
        
        return ans;
    }
}