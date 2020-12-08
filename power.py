import sys

sys.stdin = open("power_input.txt", "r")

def power(base, exp):
    if exp == 1:
        return base
    else:
        return base * power(base, exp - 1)

for test_case in range(1, 11):
    # ///////////////////////////////////////////////////////////////////////////////////
    idc = int(input())
    base, exponent = (map(int, input().split()))
    print("#%d %d" %(test_case, power(base, exponent)))
    # ///////////////////////////////////////////////////////////////////////////////////
