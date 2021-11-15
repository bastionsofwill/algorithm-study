def cut_cake(cake_left):
    if cake_left == 0:
        return 1
    res = 0
    for i in range(3):
        if cake_left >= i + 1:
            res += cut_cake(cake_left - (i + 1))
    return res

T = int(input())
for i in range(T):
    print(cut_cake(int(input())))