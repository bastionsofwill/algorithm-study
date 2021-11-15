N = int(input())
n = 1
while(n < N):
    if sum(map(int, str(n))) + n == N:
        print(n)
        exit(0)
    n += 1
print(0)