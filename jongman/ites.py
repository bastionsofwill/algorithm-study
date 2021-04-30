import collections

C = int(input())
for i in range(C):
    A = 1983
    psum_queue = collections.deque()
    psum = 0
    ans = 0
    k, n = list(map(int, input().split()))
    for _ in range(n):
        new_wave = A%10000 + 1
        psum_queue.append(new_wave)
        psum += new_wave
        while psum > k:
            psum -= psum_queue.popleft()
        if psum == k:
            ans += 1
        A = ((A*214013 + 2531011)%(2**32))
    print(ans)
        