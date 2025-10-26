class Solution:
    def maxProfit(self, prices: List[int], fee: int) -> int:
        def f(i: int, buy: int) -> int:
            if i==n:
                return 0
            if dp[i][buy]!=-1:
                return dp[i][buy]
            if buy==1:
                profit=max(-prices[i]+f(i+1,0),f(i+1,1))
            else:
                profit=max(prices[i]+f(i+1,1)-fee,f(i+1,0))
            dp[i][buy]=profit
            return dp[i][buy]
        n=len(prices)
        dp=[[-1]*3 for i in range(n)]
        return f(0,1)