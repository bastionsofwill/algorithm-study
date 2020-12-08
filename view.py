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

sys.stdin = open("view_input.txt", "r")

for test_case in range(1, 11):
    # ///////////////////////////////////////////////////////////////////////////////////
    N = int(input())
    buildingList = list(map(int, sys.stdin.readline().split()))
    buildingList.extend([0, 0])
    numFineView = 0
    for buildingIndex in range(0, N):
        buildingHeight = buildingList[buildingIndex]
        maxRivalHeight = 0
        for delta in range (-2, 3):
            if delta:
                rivalHeight = buildingList[buildingIndex + delta]
                if maxRivalHeight < rivalHeight:
                    maxRivalHeight = rivalHeight
        if (maxRivalHeight < buildingHeight):
            numFineView += (buildingHeight - maxRivalHeight)
    print("#%d %d" % (test_case, numFineView))
    # ///////////////////////////////////////////////////////////////////////////////////
