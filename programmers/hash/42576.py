def solution(participant, completion):
    p_dict = {}
    for p in participant:
        if p in p_dict:
            p_dict[p] += 1
        else:
            p_dict[p] = 1
    for c in completion:
        p_dict[c] -= 1
    for name, incompleted in p_dict.items():
        if incompleted > 0:
            return name

participant = ["leo", "kiki", "eden"]
completion = ["kiki", "eden"]

print(solution(participant, completion))