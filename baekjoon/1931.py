N = int(input())
input_list = []
ans = 0

for i in range(N):
    a, b = map(int, input().split())
    input_list.append((a, b))

meeting_list = sorted(input_list, key=lambda x: (x[1], x[0]))
while(len(meeting_list) > 0):
    meeting = meeting_list.pop(0)
    meeting_end = meeting[1]
    ans += 1
    while(len(meeting_list) > 0 and meeting_list[0][0] < meeting_end):
        meeting_list.pop(0)
print(ans)