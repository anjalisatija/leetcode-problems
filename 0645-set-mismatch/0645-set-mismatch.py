class Solution:
    def findErrorNums(self, nums: List[int]) -> List[int]:
        result = [-1, -1]
        counts = Counter(nums)

        for i in range(1, len(nums) + 1):
            if counts[i] == 2:
                result[0] = i  
            elif i not in counts:
                result[1] = i  

        return result