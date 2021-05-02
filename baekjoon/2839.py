import math
import sys

sys.setrecursionlimit(10000)

cache = {0: 0}

def find_num_bags(N):
    if N in cache:
        return cache[N]
    if N >= 5:
        cache[N] = min(find_num_bags(N - 5), find_num_bags(N - 3)) + 1
    elif N >= 3:
        cache[N] = find_num_bags(N - 3) + 1
    else: return math.inf
    return cache[N]
    
N =int(input())

ans = find_num_bags(N)
print(ans if math.isfinite(ans) else -1)