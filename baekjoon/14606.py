history = {}

def split_tower(h):
    if h == 1:
        return 0
    elif h == 2:
        return 1
    elif h in history:
        return history[h]
    else:
        next_height = int(h/2)
        history[h] = next_height*(next_height + h%2) + split_tower(next_height) + split_tower(next_height + h%2)
        return history[h]

N = int(input())
print(split_tower(N))