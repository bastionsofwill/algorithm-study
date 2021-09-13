def solution(board, skill):
    answer = 0
    for t, r1, c1, r2, c2, degree in skill:
        atk = 1 if t == 1 else -1
        for r in range(r1, r2 + 1):
            for c in range(c1, c2 + 1):
                board[r][c] -= atk*degree
    for row in board:
        for e in row:
            if e > 0:
                answer += 1
    return answer