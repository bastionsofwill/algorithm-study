import heapq

def solution(jobs):
    num_jobs = len(jobs)
    total_time = 0
    clock = 0
    tasks_arrived = []
    heapq.heapify(jobs)
    arr, ser = heapq.heappop(jobs)
    total_time += ser
    clock += (arr + ser)
    while jobs[0][0] <= clock:
        tasks_arrived = heapq.heappop(jobs)
    
    


    
    return total_time//num_jobs

jobs = [[0, 3], [1, 9], [2, 6]]
print(solution(jobs))