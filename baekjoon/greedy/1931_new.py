meeting_list = []
answer = 0
t = 0
N = int(input())
for i in range(N):
    start, end = map(int, input().split())
    meeting_list.append((start, end))

meeting_list = sorted(meeting_list, key=lambda x: (x[1], x[0]))

for meeting in meeting_list:
    if meeting[0] >= t:
        answer += 1
        t = meeting[1]
print(answer)