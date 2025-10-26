class Solution:
    def search(self, nums: List[int], target: int) -> int:
        for i in range(len(nums)):
            if target in nums:
                return nums.index(target)
            else:
                return -1