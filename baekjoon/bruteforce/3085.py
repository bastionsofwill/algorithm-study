def switch_pos(board, r, c, dir):
    if dir == 'down':
        board[r][c], board[r + 1][c] = board[r + 1][c], board[r][c]
    else:
        board[r][c], board[r][c + 1] = board[r][c + 1], board[r][c]
    return board

def find_h_path(board):
    size = len(board)
    flag = 0
    longest_path = 0
    for r in range(size):
        for c in range(size):
            if flag == 0:
                path = 1
                flag = 1
            else:
                if board[r][c - 1] == board[r][c]:
                    path += 1
                else:
                    if longest_path < path:
                        longest_path = path
                    path = 1
        if longest_path < path:
            longest_path = path
        flag = 0
    return longest_path

def find_v_path(board):
    size = len(board)
    flag = 0
    longest_path = 0
    for c in range(size):
        for r in range(size):
            if flag == 0:
                path = 1
                flag = 1
            else:
                if board[r - 1][c] == board[r][c]:
                    path += 1
                else:
                    if longest_path < path:
                        longest_path = path
                    path = 1
        if longest_path < path:
            longest_path = path
        flag = 0
    return longest_path

def find_longest_path(board):
    return max(find_h_path(board), find_v_path(board))

N = int(input())
gameboard = []
for i in range(N):
    gameboard.append(list(input()))
answer = 0
for i in range(N):
    for j in range(N):
        if i != N - 1 and gameboard[i][j] != gameboard[i + 1][j]:
            path = find_longest_path(switch_pos(gameboard, i, j, 'down'))
            switch_pos(gameboard, i, j, 'down')
            if answer < path:
                answer = path
        if j != N - 1 and gameboard[i][j] != gameboard[i][j + 1]:
            path = find_longest_path(switch_pos(gameboard, i, j, 'right'))
            switch_pos(gameboard, i, j, 'right')
            if answer < path:
                answer = path
print(answer)