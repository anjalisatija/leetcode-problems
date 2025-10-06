import math

class Solution:
  def findUnsortedSubarray(self, nums: list[int]) -> int:
    mn = math.inf
    mx = -math.inf
    flag = False

    # Find the minimum in the unsorted part
    for i in range(1, len(nums)):
      if nums[i] < nums[i - 1]:
        flag = True
      if flag:
        mn = min(mn, nums[i])

    flag = False
    # Find the maximum in the unsorted part
    for i in reversed(range(len(nums) - 1)):
      if nums[i] > nums[i + 1]:
        flag = True
      if flag:
        mx = max(mx, nums[i])

    # Left boundary
    for l in range(len(nums)):
      if nums[l] > mn:
        break

    # Right boundary
    for r, num in reversed(list(enumerate(nums))):
      if num < mx:
        break

    return 0 if l >= r else r - l + 1