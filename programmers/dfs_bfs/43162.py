def solution(n, computers):
    computer_connected = [0 for x in range(n)]
    answer = 0
    for i in range(n):
        if computer_connected[i] == 0:
            answer += 1
            visited = [0 for x in range(n)]
            for connected in find_connection(i, visited, computers):
                computer_connected[connected] = 1
    return answer

def find_connection(src, visited, computers):
    visited[src] = 1
    connected = [src]
    for connect_idx in range(len(computers)):
        if visited[connect_idx] == 0 and computers[src][connect_idx] == 1:
            connected += find_connection(connect_idx, visited, computers)
    return connected
    
computers = [[1, 0, 0, 1, 0, 0], [0, 1, 0, 1, 0, 0], [0, 0, 1, 0, 0, 1], [1, 1, 0, 1, 0, 0], [0,0,0,0,1,0], [0,0,1,0,0,1]]
print(solution(6, computers))
