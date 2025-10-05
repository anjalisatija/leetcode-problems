class Solution:
    def optimalDivision(self, nums: List[int]) -> str:
        if len(nums) == 1:
            return str(nums[0])
        elif len(nums) == 2:
            return str(nums[0]) + '/' + str(nums[1])
        else:
            nums_str = list(map(str, nums))
            return str(nums[0]) + '/(' + '/'.join(nums_str[1:]) + ')'