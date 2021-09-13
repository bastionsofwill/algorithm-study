from collections import deque

def is_transformable(s1, s2):
    diff = 0
    for i in range(len(s1)):
        if s1[i] != s2[i]:
            diff += 1
    return True if diff == 1 else False

def solution(begin, target, words):
    answer = 0
    if begin in words:
        words.remove(begin)
    visited = [0 for x in range(len(words))]
    q = deque()
    q.append((begin, answer))
    while len(q) != 0:
        answer += 1
        current_word, step = q.pop()
        if current_word == target:
            return step
        for i in range(len(words)):
            if visited[i] == 0 and is_transformable(current_word, words[i]):
                q.append((words[i], answer))
                visited[i] = 1
    return 0

begin = "hit"
target = "cog"
words = ["hot", "dot", "dog", "lot", "log", "cog"]

print(solution(begin, target, words))