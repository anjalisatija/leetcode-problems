class Solution:
    def distributeCandies(self, candyType: List[int]) -> int:
        n = len(candyType) // 2
        counts = Counter(candyType)
        return min(n, len(counts))