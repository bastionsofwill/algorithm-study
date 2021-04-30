N, M = -1, -1
gameboard = []
cache = []

def jump(r, c):
    if r >= M or c >= M:
        return 0
    elif r == M - 1 and c == M - 1:
        return 1
    # print('r: ', r, 'c: ', c)
    if cache[r][c] != -1:
        # print('cache hit')
        return cache[r][c]
    next_r = r + gameboard[r][c]
    next_c = c + gameboard[r][c]
    cache[r][c] = jump(next_r , c) or jump(r, next_c)
    return cache[r][c]

N = int(input())
for i in range(N):
    M = int(input())
    gameboard = []
    cache = [[-1]*M for _ in range(M)]
    for j in range(M):
        gameboard.append(list(map(int, input().split())))
    print('YES' if jump(0, 0) == 1 else 'NO')