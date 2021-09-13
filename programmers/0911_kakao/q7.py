def find_ground(board, loc):
    r, c = loc
    l = len(board)
    ans = []
    if r > 0 and board[r - 1][c] == 1:
        ans.append([r - 1, c])
    if r < l - 1 and board [r + 1][c] == 1:
        ans.append([r + 1, c])
    if c > 0 and board[r][c - 1] == 1:
        ans.append([r, c - 1])
    if c < l - 1 and board[r][c + 1] == 1:
        ans.append([r, c + 1])
    return ans

def solution(board, aloc, bloc):
    grounds = find_ground(board, aloc)
    print(grounds)
    min_move = 10000000
    if len(grounds) == 0:
        return 0
    elif aloc == bloc:
        return 1
    else:
        for next_loc in grounds:
            board[aloc[0]][aloc[1]] = 0
            if len(find_ground(board, next_loc)) == 0:
                if next_loc == bloc:
                    return 1
                else:
                    board[aloc[0]][aloc[1]] = 1
                    continue
            new_move = solution(board, bloc, next_loc) + 1
            if new_move < min_move:
                min_move = new_move
            board[aloc[0]][aloc[1]] = 1
        return new_move

board = [[1, 1, 1], [1, 1, 1], [1, 1, 1]]
aloc = [1, 0]
bloc = [1, 2]

print(solution(board, aloc, bloc))