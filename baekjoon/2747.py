N = int(input())
ans_dict = {0: 0, 1: 1, 2: 1}

def fib(N):
    if N in ans_dict.keys():
        return ans_dict[N]
    else:
        ans_dict[N] = fib(N - 1) + fib(N - 2)
        return ans_dict[N]

print(fib(N))