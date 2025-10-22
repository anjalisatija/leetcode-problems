class Solution:
    # https://leetcode.com/problems/stickers-to-spell-word/solutions/233915/python-12-lines-solution/
    def minStickers(self, stickers: List[str], target: str) -> int:
        counts = [Counter(s) for s in stickers]
        # T = O(N * W * N) - N is letters in target and S = number of stickers and N for creating next target
        # S = O(N) for stack and O(kW) for counters 
        @lru_cache(None)
        def dfs(target):
            if not target: 
                return 0

            targetCount = collections.Counter(target)
            ans = math.inf
            for count in counts:
                # choose a sticker only if it is able to eliminate 
                # first character of target (to reduce search space)
                if target[0] not in count:
                    continue 
                # counters will only reduce count of letters present in 
                # targetCount and will set count to 0 if Count has more 
                # of those letters
                remaining = targetCount - count
                # convert the remaining letters back to word
                letters = [ s * c for s, c in remaining.items() ]
                letters.sort()
                nextTarget = "".join(letters)
                # explore how many stickers will be needed for new target
                ans = min(ans, dfs(nextTarget))
            # ans will be 1 sticker used before + remaining ans
            return 1 + ans

        ans = dfs(target)
        return ans if ans != math.inf else -1