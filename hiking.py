# 표준 입력 예제
'''
a = int(input())                        정수형 변수 1개 입력 받는 예제
b, c = map(int, input().split())        정수형 변수 2개 입력 받는 예제 
d = float(input())                      실수형 변수 1개 입력 받는 예제
e, f, g = map(float, input().split())   실수형 변수 3개 입력 받는 예제
h = input()                             문자열 변수 1개 입력 받는 예제
'''

# 표준 출력 예제
'''
a, b = 6, 3
c, d, e = 1.0, 2.5, 3.4
f = "ABC"
print(a)                                정수형 변수 1개 출력하는 예제
print(b, end = " ")                     줄바꿈 하지 않고 정수형 변수와 공백을 출력하는 예제
print(c, d, e)                          실수형 변수 3개 출력하는 예제
print(f)                                문자열 1개 출력하는 예제
'''

import sys

sys.stdin = open("sample_input.txt", "r")

T = int(input())
dir = [(-1, 0), (1, 0), (0, -1), (0, 1)]

def next(src):
    return [(src[0] + x[0], src[1] + x[1]) for x in dir]

def search(src, depth, constr):
    global longestPathLocal
    mtVisited[src[0]][src[1]] = True
    nextPoint = next(src)
    if depth > longestPathLocal:
        longestPathLocal = depth
    for dst in nextPoint:
        if (dst[0] < 0) or (dst[1] < 0) or (dst[0] >= N) or (dst[1] >= N) or mtVisited[dst[0]][dst[1]]:
            continue
        elif mtMap[src[0]][src[1]] > mtMap[dst[0]][dst[1]]:
            search(dst, depth + 1, constr)
    return
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    # ///////////////////////////////////////////////////////////////////////////////////
    mtMap = []
    mtRow = []
    mtHeight = 0
    mtSummit = []
    longestPathGlobal = 0
    (N, K) = list(map(int, sys.stdin.readline().split()))
    for r in range(0, N):
        mtRow = list(map(int, sys.stdin.readline().split()))
        c = 0
        for pointHeight in mtRow:
            if mtHeight < pointHeight:
                mtSummit = []
                mtSummit.append((r, c))
                mtHeight = pointHeight
            elif mtHeight == pointHeight:
                mtSummit.append((r, c))   
            c += 1
        mtMap.append(mtRow)
    for startPoint in mtSummit:
        longestPathLocal = 0
        mtVisited = [[False]*N]*N
        search(startPoint, 1, True)
        if longestPathGlobal < longestPathLocal:
            longestPathGlobal = longestPathLocal
    print(longestPathGlobal)
    # ///////////////////////////////////////////////////////////////////////////////////
