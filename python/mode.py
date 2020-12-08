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

sys.stdin = open("mode_input.txt", "r")

T = int(input())

for test_case in range(1, T + 1):
    # ///////////////////////////////////////////////////////////////////////////////////
    idc = int(input())
    scoreList = list(map(int, input().split()))
    dataBin = [0]*101
    for score in scoreList:
        dataBin[score] += 1
    modValue = max(dataBin)
    dataBin.reverse()
    print("#%d %d" % (test_case, len(dataBin) - 1 - dataBin.index(modValue)))
    # ///////////////////////////////////////////////////////////////////////////////////
