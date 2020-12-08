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

sys.stdin = open("palindrome2_input.txt", "r")

def findPalinLength(string):
    stringLength = len(string)
    for stringIndex in range(0, int(stringLength/2)):
        if string[stringIndex] != string[stringLength - 1 - stringIndex]:
            return 0
    return stringLength

def findLongestPalinLength(string):
    longestPalinLength = 1
    for startIndex in range(0, len(string) - 1):
        for endIndex in range(startIndex + 1, len(string)):
            palinLength = findPalinLength(string[startIndex:endIndex + 1])
            if longestPalinLength < palinLength:
                longestPalinLength = palinLength
    return longestPalinLength

for test_case in range(1, 11):
    # ///////////////////////////////////////////////////////////////////////////////////
    wordMatrix = []
    maxPalinLength = 1
    idc = int(input())
    for row in range(0, 100):
        wordRow = input()
        currentRowPalinLength = findLongestPalinLength(wordRow)
        if maxPalinLength < currentRowPalinLength:
            maxPalinLength = currentRowPalinLength 
        wordMatrix.append(wordRow)
    transMatrix = []
    for colIndex in range(0, len(wordMatrix[0])):
        tempstring = ""
        for rowIndex in range(0, len(wordMatrix)):
            tempstring += wordMatrix[rowIndex][colIndex]
        transMatrix.append(tempstring)
    for transRow in transMatrix:
        transRowPalinLength = findLongestPalinLength(transRow)
        if maxPalinLength < transRowPalinLength:
            maxPalinLength = transRowPalinLength
    print("#%d %d" % (test_case, maxPalinLength))
    # ///////////////////////////////////////////////////////////////////////////////////