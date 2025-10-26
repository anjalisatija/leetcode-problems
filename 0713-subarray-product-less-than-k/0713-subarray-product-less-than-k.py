from typing import List

class Solution:
    def numSubarrayProductLessThanK(self, nums: List[int], k: int) -> int:
        if k <= 1:
            return 0
        
        n = len(nums)
        count = 0
        left = 0
        currentProduct = 1
        
        for right in range(n):
            currentProduct *= nums[right]
            
            while currentProduct >= k:
                currentProduct //= nums[left]
                left += 1
            
            count += right - left + 1
        
        return count