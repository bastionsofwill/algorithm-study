N, a, b = map(int, input().split())
D = set(map(int, input().split()))
S = set(map(int, input().split()))

damaged = list(D - S)
surplus = list(S - D)

answer = len(damaged)
for team in damaged:
    if team - 1 in surplus:
        answer -= 1
        surplus.remove(team - 1)
    elif team + 1 in surplus:
        answer -= 1
        surplus.remove(team + 1)
print(answer)