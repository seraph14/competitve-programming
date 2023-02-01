class Solution:
    def bestTeamScore(self, scores: List[int], ages: List[int]) -> int:
        n = len(scores)
        age_score = [(ages[i], scores[i]) for i in range(n)] + [(0, 0)]
        age_score.sort()
        
        dp = [[0] * (n+2) for _ in range(n+2)]

        for i in reversed(range(n+1)):
            for j in range(n+1):
                if (age_score[j][0] == age_score[i][0] or 
                    age_score[j][1] <= age_score[i][1]):
                    dp[i][j] = max(age_score[i][1] + dp[i+1][i], dp[i+1][j])
                else:
                    dp[i][j] = dp[i+1][j]

        return dp[0][0]
    
