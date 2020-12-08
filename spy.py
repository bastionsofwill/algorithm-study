import collections
from functools import reduce

def solution(clothes):
    kind_count = collections.Counter([kind for (name, kind) in clothes])
    print(kind_count.values())
    return reduce(lambda x, y: x*(y + 1), kind_count.values(), 1) - 1

clothes = [["yellow_hat", "headgear"], ["blue_sunglasses", "eyewear"], ["green_turban", "headgear"]]
print(solution(clothes))