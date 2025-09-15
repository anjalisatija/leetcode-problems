class Solution {
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        Integer[] result = new Integer[n];
        int[] indices = new int[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;  // Initially, indices are just [0, 1, 2, ..., n-1]
            result[i] = 0;   // Initialize result array with zeros
        }
        mergeSort(nums, indices, result, 0, n - 1);
        return Arrays.asList(result);
    }
    
    private void mergeSort(int[] nums, int[] indices, Integer[] result, int left, int right) {
        if (left == right) return;
        
        int mid = left + (right - left) / 2;
        mergeSort(nums, indices, result, left, mid);
        mergeSort(nums, indices, result, mid + 1, right);
        merge(nums, indices, result, left, mid, right);
    }
    
    private void merge(int[] nums, int[] indices, Integer[] result, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int[] tempIndices = new int[right - left + 1];
        
        int i = left, j = mid + 1, k = 0, count = 0;
        
        // Merge and count
        while (i <= mid && j <= right) {
            if (nums[indices[i]] <= nums[indices[j]]) {
                result[indices[i]] += count;  // Update the count for nums[indices[i]]
                temp[k] = indices[i];
                tempIndices[k++] = indices[i++];
            } else {
                count++;  // Increment count since nums[indices[j]] < nums[indices[i]]
                temp[k] = indices[j];
                tempIndices[k++] = indices[j++];
            }
        }
        
        while (i <= mid) {
            result[indices[i]] += count;
            temp[k] = indices[i];
            tempIndices[k++] = indices[i++];
        }
        
        while (j <= right) {
            temp[k] = indices[j];
            tempIndices[k++] = indices[j++];
        }
        
        System.arraycopy(temp, 0, indices, left, temp.length);
    }
}