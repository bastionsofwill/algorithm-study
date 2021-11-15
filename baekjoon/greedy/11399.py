N = int(input())
time_list = list(map(int, input().split()))
time_list.sort()

answer = 0
time_spent = 0
for t in time_list:
    time_spent += t
    answer += time_spent
print(answer)