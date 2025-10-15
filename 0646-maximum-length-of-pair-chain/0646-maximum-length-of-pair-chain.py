class Solution:
    def findLongestChain(self, pairs: List[List[int]]) -> int:
        s = sorted(pairs)
        tail = s[-1]
        l = 1
        for pair in reversed(s[:-1]):
            if pair[1] < tail[0]:
                tail = pair
                l += 1
        return l
            