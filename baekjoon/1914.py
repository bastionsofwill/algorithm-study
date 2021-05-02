def print_hanoi(N, src, dst):
    if N == 1:
        print(str(src) + " " + str(dst))
    else:
        print_hanoi(N - 1, src, 6 - src - dst)
        print(str(src) + " " + str(dst))
        print_hanoi(N - 1, 6 - src - dst, dst)

N = int(input())

print(pow(2, N) - 1)

if N <= 20:
    print_hanoi(N, 1, 3)