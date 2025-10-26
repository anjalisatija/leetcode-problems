class KthLargest:
    import heapq

    def __init__(self, k: int, nums: List[int]):
        heap = nums if len(nums) <= k else nums[:k]
        remainder = [] if len(nums) <= k else nums[k:]
        heapq.heapify(heap)
        for num in remainder:
            heapq.heappushpop(heap, num)
        self.heap = heap
        self.k = k

    def add(self, val: int) -> int:
        if len(self.heap) < self.k:
            heapq.heappush(self.heap, val)
        else:
            heapq.heappushpop(self.heap, val)
        return self.heap[0]