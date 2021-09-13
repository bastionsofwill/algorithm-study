import heapq

def solution(scoville, K):
    heapq.heapify(scoville)
    if len(scoville) == 0:
        return -1
    answer = 0
    least_spicy = heapq.heappop(scoville)
    while least_spicy < K:
        if len(scoville) == 0:
            return -1
        answer += 1
        heapq.heappush(scoville, least_spicy + 2*heapq.heappop(scoville))
        least_spicy = heapq.heappop(scoville)
    return answer

scoville = [1, 2, 3, 9, 10, 12]
K = 7
print(solution(scoville, K))