class Solution:
    def hasAlternatingBits(self, n: int) -> bool:
        bits = int(math.log2(n))
        return False if(n & (n >> 1)) or (~n & (~n >> 1) & ((1 << bits) - 1)) else True
        