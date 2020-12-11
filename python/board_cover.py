import copy

def find_next_src(gameBoard):
    for r in range(len(gameBoard)):
        for c in range(len(gameBoard[0])):
            if gameBoard[r][c]: return (r, c)
    return null
def find_new_block(H, W, src, delta):
    new_block = []
    for spot in delta:
        r, c = [sum(x) for x in zip(src, spot)]
        if(r < 0 or c < 0 or r >= H or c >= W):
            return None
        else:
            new_block.append((r, c))
    return new_block    
def recursiveFill(gameBoard, numEmpty):
    if numEmpty == 0: return 1
    if numEmpty%3 != 0: return 0
    ans = 0
    newBoard = copy.deepcopy(gameBoard)
    next_src = find_next_src(gameBoard)
    delta_list = (((1, 0), (0, 1)),
             ((1, 0), (1, -1)),
             ((1, 0), (1, 1)),
             ((0, 1), (1, 1)))
    newBoard[next_src[0]][next_src[1]] = False
    for delta in delta_list:
        new_block = find_new_block(len(gameBoard), len(gameBoard[0]), next_src, delta)
        if (new_block and newBoard[new_block[0][0]][new_block[0][1]] and newBoard[new_block[1][0]][new_block[1][1]]):
            newBoard[new_block[0][0]][new_block[0][1]] = False
            newBoard[new_block[1][0]][new_block[1][1]] = False
            ans += recursiveFill(newBoard, numEmpty - 3)
            newBoard[new_block[0][0]][new_block[0][1]] = True
            newBoard[new_block[1][0]][new_block[1][1]] = True
    newBoard[next_src[0]][next_src[1]] = True
    return ans

T = int(input())
for testcase in range(T):
    H, W = map(int, input().split(" "))
    gameBoard = []
    numEmpty = 0
    for i in range(H):
        row = input()
        gameBoard.append(list(map(lambda i: True if i == "." else False, row)))
    for r in gameBoard:
        for e in r:
            if e:
                numEmpty += 1
    print(recursiveFill(gameBoard, numEmpty))