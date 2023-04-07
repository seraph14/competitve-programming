class Solution:
    def numDecodings(self, s: str) -> int:
        mod = 10 ** 9 + 7
        alts = {str(num): str(num) for num in range(10)}
        alts["*"] = [str(i) for i in range(1, 10)]

        @cache
        def dp(i):
            if i == len(s):
                return 1
            if s[i] == "0":
                return 0
            
            ways = 0
            
            for a in alts[s[i]]:
                ways = (ways + dp(i+1)) % mod
                if i+1 == len(s):
                    continue
                for b in alts[s[i+1]]:
                    if 0 < int(a+b) <= 26: 
                        ways = (ways + dp(i+2)) % mod
            
            return ways

        return dp(0)
