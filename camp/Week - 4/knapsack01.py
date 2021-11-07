testCases = int(input())
tests = []
for _ in range(testCases):
    s, n = map(int, input().split())
    weights = [0 for _ in range(n)]
    values = [0 for _ in range(n)]
    for i in range(n):
      weights[i], values[i] = map(int, input().split())
    tests.append((s, weights, values))


for test in tests:
    s, weights, values = test
    dp = [[0 for _ in range(s+1)] for _ in range(len(weights) + 1)]
    
    for i in range(1, len(dp)):
      for w in range(1, len(dp[i])):
        if w > weights[i-1]:
          dp[i][w] = max(dp[i-1][w], dp[i-1][w - weights[i-1]] + values[i-1])
        else:
          dp[i][w] = dp[i-1][w]
    print(max(dp[-1]))
