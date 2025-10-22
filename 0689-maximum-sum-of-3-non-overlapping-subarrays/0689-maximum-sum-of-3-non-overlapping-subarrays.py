from typing import List

class Solution:
    def maxSumOfThreeSubarrays(self, nums: List[int], k: int) -> List[int]:
        n = len(nums)
        subarray_sum = [0] * (n - k + 1)
        current_sum = sum(nums[:k])
        subarray_sum[0] = current_sum
        for i in range(1, n - k + 1):
            current_sum += nums[i + k - 1] - nums[i - 1]
            subarray_sum[i] = current_sum
        
      
        left = [0] * (n - k + 1)
        right = [0] * (n - k + 1)
        
        
        for i in range(1, n - k + 1):
            left[i] = left[i - 1] if subarray_sum[i] <= subarray_sum[left[i - 1]] else i
        
        
        right[n - k] = n - k
        for i in range(n - k - 1, -1, -1):
            right[i] = right[i + 1] if subarray_sum[i] < subarray_sum[right[i + 1]] else i
        
        
        max_sum = 0
        result = []
        for mid in range(k, n - 2 * k + 1):
            left_index = left[mid - k]
            right_index = right[mid + k]
            total_sum = subarray_sum[left_index] + subarray_sum[mid] + subarray_sum[right_index]
            
            
            if total_sum > max_sum or (total_sum == max_sum and [left_index, mid, right_index] < result):
                max_sum = total_sum
                result = [left_index, mid, right_index]
        
        return result