class Solution:
    def findMaxAverage(self, nums: List[int], k: int) -> float:
        current_sum = sum(nums[:k])
        max_sum = current_sum
        
        for j in range(1, len(nums)-k+1):
            current_sum = current_sum - nums[j-1] + nums[j+k-1]
            max_sum = max(max_sum, current_sum)
            
        
        return max_sum / k