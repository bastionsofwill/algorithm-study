class MinHeap:
    def __init__(self, scoville):
        self.heap = [-1] + sorted(scoville)
    def add(self, new_element):
        new_idx = len(self.heap)
        self.heap.append(new_element)
        while self.heap[new_idx] < self.heap[new_idx//2]:
            self.heap[new_idx], self.heap[new_idx//2] = self.heap[new_idx//2], self.heap[new_idx]
            new_idx //= 2
    def pop(self):
        heap_size = len(self.heap) - 1
        if heap_size == 1:
            return self.heap.pop()
        min_val = self.heap[1]
        self.heap[1] = self.heap.pop()
        heap_size -= 1
        idx_now = 1
        while 2*idx_now + 1 <= heap_size:
            l_idx = idx_now*2
            r_idx = idx_now*2 + 1
            min_child_idx = l_idx if self.heap[l_idx] < self.heap[r_idx] else r_idx
            if self.heap[idx_now] > self.heap[min_child_idx]:
                self.heap[idx_now], self.heap[min_child_idx] = self.heap[min_child_idx], self.heap[idx_now]
                idx_now = min_child_idx
            else:
                break
        if 2*idx_now == heap_size and self.heap[idx_now] > self.heap[2*idx_now]:
            self.heap[idx_now], self.heap[2*idx_now] = self.heap[2*idx_now], self.heap[idx_now]
        return min_val        

def solution(scoville, K):
    foods = MinHeap([])
    for food in scoville:
        foods.add(food)
    if len(foods.heap) == 1:
        return -1
    answer = 0
    least_spicy = foods.pop()
    while least_spicy < K:
        if len(foods.heap) == 1:
            return -1
        answer += 1
        foods.add(least_spicy + 2*foods.pop())
        least_spicy = foods.pop()
    return answer

scoville = [1, 2, 3, 9, 10, 12]
K = 7
print(solution(scoville, K))