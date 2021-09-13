def solution(clothes):
    c_dict = {}
    for n, t in clothes:
        if t in c_dict:
            c_dict[t].append(n)
        else:
            c_dict[t] = [n]
    answer = 1
    for t, c_list in c_dict.items():
        answer *= len(c_list) + 1
    return answer - 1

clothes = [["yellowhat", "headgear"], ["bluesunglasses", "eyewear"], ["green_turban", "headgear"]]
print(solution(clothes))