def solution(n, lost, reserve):
    L = set(lost)
    R = set(reserve)
    lost = list(L - R)
    reserve = list(R - L)
    answer = n - len(lost)
    for l in lost:
        if l - 1 in reserve:
            answer += 1
            reserve.remove(l - 1)
        elif l + 1 in reserve:
            answer += 1
            reserve.remove(l + 1)
    return answer

lost = [1,2,3,4,5]
reserve = [1,2,3,4,5]
print(solution(5, lost, reserve))