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
from collections import deque

sys.stdin = open("routeFinding_input.txt", "r")

def isAccessible():
    availablePoints = deque()
    isVisited = [0]*100
    availablePoints.append(0)
    while len(availablePoints):
        src = availablePoints.popleft()
        print(src)
        for dstIndex in range(0, 100):
            if pathMap[src][dstIndex] and not(isVisited[dstIndex]):
                if dstIndex == 99:
                    return 1
                else:
                    availablePoints.append(dstIndex)
                    isVisited[dstIndex] = 1
    return 0

for test_case in range(1, 11):
    # ///////////////////////////////////////////////////////////////////////////////////
    pathMap = [[0]*100]*100
    idc, numOfPath = map(int, input().split())
    N = list(map(int, input().split()))

    for i in range(0, numOfPath):
        pathMap[N[2*i - 2]][N[2*i - 1]] = 1

    print("#%d %d" %(test_case, isAccessible()))
    # ///////////////////////////////////////////////////////////////////////////////////