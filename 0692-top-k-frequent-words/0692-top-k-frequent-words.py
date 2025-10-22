class Solution(object):
    def topKFrequent(self, words, k):
        count = Counter(words)
        sorted_words = sorted(count.keys(), key=lambda x: (-count[x], x))
        return sorted_words[:k]