# from collections import deque

# a = deque([0,1,2,3])

# print(a[1])

# a, b = map(int, input().split())
# print(a)
# print(b)

import operator
def generate_vec(dot1, dot2):
    return [dot1[i] - dot2[i] for i in range(2)]

def dotproduct(vec1, vec2):
    return sum(map(operator.mul, vec1, vec2))

def solution(v):
    answer = []
    vector_list = []
    for i in range(3):
        vector_list.append(generate_vec(v[i], v[(i+1)%3]))
    print(vector_list)
    
    for j in range(3):
        answer.append(dotproduct(vector_list[j], vector_list[(j+1)%3]))
    return answer

print([sum(x) for x in zip([1, 4],[3, 6])])