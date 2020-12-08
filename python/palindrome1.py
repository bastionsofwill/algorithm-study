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

sys.stdin = open("palindrome1_input.txt", "r")

def isPalin(string):
    stringLength = len(string)
    for stringIndex in range(0, int(stringLength/2)):
        if string[stringIndex] != string[stringLength - 1 - stringIndex]:
            return False
    return True

def searchRow(wordRow, palinLength):
    numofPalin = 0
    for letterIndex in range(0, len(wordRow)):
        if (len(wordRow) - letterIndex) < palinLength:
            return numofPalin
        else:
            if isPalin(wordRow[letterIndex:(letterIndex + palinLength)]):
                numofPalin += 1
    return -1

for test_case in range(1, 11):
    # ///////////////////////////////////////////////////////////////////////////////////
    wordMatrix = []
    totalPalin = 0
    palinLength = int(input())
    for row in range(0, 8):
        wordRow = input()
        totalPalin += searchRow(wordRow, palinLength)
        wordMatrix.append(wordRow)
    transMatrix = []
    for colIndex in range(0, len(wordMatrix[0])):
        tempstring = ""
        for rowIndex in range(0, len(wordMatrix)):
            tempstring += wordMatrix[rowIndex][colIndex]
        transMatrix.append(tempstring)
    for transRow in transMatrix:
        totalPalin += searchRow(transRow, palinLength)
    print("#%d %d" % (test_case, totalPalin))
    # ///////////////////////////////////////////////////////////////////////////////////
