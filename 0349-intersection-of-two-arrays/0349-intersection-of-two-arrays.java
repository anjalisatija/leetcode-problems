class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int[] freq = new int[1001];
        int n = 0;

        for (int num: nums1) freq[num] = 1;
        for (int num: nums2) if (freq[num] == 1) {
            freq[num] = 2;
            n++;
        }
        
        int[] res = new int[n];

        if (nums1.length > nums2.length) {
            for (int num: nums2) if (freq[num] == 2) {
                freq[num] = 1;
                res[--n] = num;
            }
        } else {
            for (int num: nums1) if (freq[num] == 2) {
                freq[num] = 1;
                res[--n] = num;
            }
        }

        return res;
    }
}