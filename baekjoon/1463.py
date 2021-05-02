X = int(input())

ans_dict = {1: 0}

def operation_results(N):
    return (N//3 if N%3 == 0 else False, N//2 if N%2 == 0 else False, N - 1 if N > 1 else False)

def calculate(N):
    if N in ans_dict.keys():
        return ans_dict[N]
    else:
        for result in operation_results(N):
            if result:
                temp_result = 1 + calculate(result)
                if N not in ans_dict.keys():
                    ans_dict[N] = temp_result
                elif temp_result < ans_dict[N]:
                    ans_dict[N] = temp_result
        return ans_dict[N]

print(calculate(X))
print(ans_dict)