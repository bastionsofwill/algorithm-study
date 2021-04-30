C = int(input())
for i in range(C):
    n = int(input())
    sequence = list(map(int, input().split()))
    print(find_lis_len(sequence))