def search(src, network_list):
    visited_list[src] = True
    for computer_idx, is_connected in enumerate(network_list[src]):
        if not visited_list[computer_idx] and is_connected:
            search(computer_idx, network_list)
    return

def solution(n, computers):
    answer = 0
    global visited_list
    visited_list = [False]*n
    for computer_idx, is_visited in enumerate(visited_list):
        if not is_visited:
            search(computer_idx, computers)
            answer += 1
    return answer

n = 12
computers = [[1, 1, 0, 0, 0, 0, 0, 0, 0 ,0 ,0 ,0],
             [1, 1, 1, 0, 0, 0, 0, 0, 0 ,0 ,0 ,0], 
             [0, 1, 1, 1, 0, 0, 0, 0, 0 ,0 ,0 ,0], 
             [0, 0, 1, 1, 1, 0, 0, 0, 0 ,0 ,0 ,0],
             [0, 0, 0, 1, 1, 0, 0, 0, 0 ,0 ,0 ,0],
             [0, 0, 0, 0, 0, 1, 0, 0, 0 ,0 ,0 ,0],
             [0, 0, 0, 0, 0, 0, 1, 1, 0 ,0 ,0 ,0],
             [0, 0, 0, 0, 0, 0, 1, 1, 0 ,0 ,0 ,0],
             [0, 0, 0, 0, 0, 0, 0, 0, 1 ,0 ,0 ,0],
             [0, 0, 0, 0, 0, 0, 0, 0, 0 ,1 ,0 ,0],
             [0, 0, 0, 0, 0, 0, 0, 0, 0 ,0 ,1 ,0],
             [0, 0, 0, 0, 0, 0, 0, 0, 0 ,0 ,0 ,1]]

print(solution(n, computers))