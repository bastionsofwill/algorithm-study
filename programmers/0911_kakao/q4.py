def solution(n, info):
    answer = []
    p = []
    for i in info[:-1]:
        p.append((0, i, i + 1))
    
    return answer

n = 5
info = [2,1,1,1,0,0,0,0,0,0,0]

print(solution(n, info))