# Codeforces-1245C-Constanze-s-Machine
Link: https://codeforces.com/problemset/problem/1245/C
## Recurrence Relation
```
recurrence relation:
dp = dp[i-1]
dp[i] = dp[i] + d[i-2]

example: 
0 1 2 3 4 5
u u u u u i

dp[0] = 1
dp[1] = 1

dp[2] = dp[1] = 1
dp[2] = dp[2] + dp[0] = 1 + 1 = 2

dp[3] = dp[2] = 2
dp[3] = dp[3] + dp[1] = 2 + 1 = 3

dp[4] = dp[3] = 3
dp[4] = dp[4] + dp[2] = 3 + 2 = 5

dp[5] = dp[4] = 5
dp[5] = dp[5] + dp[3] = 5 + 3 = 8
```
