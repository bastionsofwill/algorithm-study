N = int(input())
a = 0
b = 1

if N == 0:
    print(a)
elif N == 1:
    print(b)
else:
    for i in range(N - 1):
        c = a + b
        a = b
        b = c
    print(c)