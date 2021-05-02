import math

cache = {1: 0}

X = int(input())

def calc(N):
    for i in range(2, N + 1):
        temp_div_3 = math.inf
        temp_div_2 = math.inf
        if i%3 == 0:
            temp_div_3 = cache[i//3]+ 1
        if i%2 == 0:
            temp_div_2 = cache[i//2] + 1
        temp_sub_1 = cache[i - 1] + 1
        cache[i] = min(temp_div_3, temp_div_2, temp_sub_1)
    return cache[N]

print(calc(X))