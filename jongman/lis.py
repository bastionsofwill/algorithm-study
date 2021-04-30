def find_lis_len(sequence):
    if len(sequence) == 0:
        return 0
    max_len = 1
    for start_idx in range(len(sequence)):
        templist = []
        for number in sequence[start_idx + 1:]:
            if number > sequence[start_idx]:
                templist.append(number)
        new_len = 1 + find_lis_len(templist)
        if max_len < new_len:
            max_len = new_len
    return max_len

C = int(input())
for i in range(C):
    n = int(input())
    sequence = list(map(int, input().split()))
    print(find_lis_len(sequence))