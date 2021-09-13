def solution(s):
    answer = []
    s_list = []
    for e in s[1:-1].split('}')[:-1]:
        s_list.append(list(map(int, e.strip(',{').split(','))))
    s_list.sort(key=len)
    for s_set in s_list:
        for c in s_set:
            if c not in answer:
                answer.append(c)
    return answer

s = "{{1, 2, 3, 4, 5},{2},{2,1},{2,1,3},{2,1,3,4}}"
print(solution(s))
