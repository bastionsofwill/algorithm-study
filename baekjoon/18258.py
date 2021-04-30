import collections
import sys

class CustomQueue:
    def __init__(self):
        self.queue = collections.deque()
    def push(self, num):
        self.queue.append(num)
    def pop(self):
        print(-1 if len(self.queue) == 0 else self.queue.popleft())
    def size(self):
        print(len(self.queue))
    def empty(self):
        print(1 if len(self.queue) == 0 else 0)
    def front(self):
        temp = (-1 if len(self.queue) == 0 else self.queue.popleft())
        print(temp)
        if temp != -1:
            self.queue.appendleft(temp)
    def back(self):
        temp = (-1 if len(self.queue) == 0 else self.queue.pop())
        print(temp)
        if temp != -1:
            self.queue.append(temp)

q = CustomQueue()
N = int(input())
for i in range(N):
    cmd_line = list(sys.stdin.readline().split())
    cmd = cmd_line[0]
    if cmd == 'push':
        q.push(int(cmd_line[1]))
    elif cmd == 'pop':
        q.pop()
    elif cmd == 'size':
        q.size()
    elif cmd == 'empty':
        q.empty()
    elif cmd == 'front':
        q.front()
    elif cmd == 'back':
        q.back()