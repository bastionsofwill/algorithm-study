import math
import sys

sys.setrecursionlimit(10**6 + 1)

cache = {1: 0}
cnt = 0
def make_one(N):
    global cnt
    if N in cache.keys():
        return cache[N]
    cnt += 1
    temp_div_3 = math.inf
    temp_div_2 = math.inf
    if N%3 == 0:
        temp_div_3 = make_one(N//3) + 1
    if N%2 == 0:
        temp_div_2 = make_one(N//2) + 1
    temp_sub_1 = make_one(N - 1) + 1
    cache[N] = min(temp_div_3, temp_div_2, temp_sub_1)
    return cache[N]

X = int(input())
print(make_one(X))
print(cnt)