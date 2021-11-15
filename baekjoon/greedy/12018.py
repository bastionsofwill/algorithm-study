n, m = map(int, input().split())
limit_list = []
mileage_list = []
min_mileage = []
for i in range(n):
    e, l = map(int, input().split())
    limit_list.append(l)
    mileage_list.append(sorted(list(map(int, input().split())), key=lambda x: -x))
for lecture_idx in range(n):
    candidate_list = mileage_list[lecture_idx]
    lecture_limit = limit_list[lecture_idx]
    if len(candidate_list) < lecture_limit:
        min_mileage.append(1)
    else:
        min_mileage.append(mileage_list[lecture_idx][lecture_limit - 1])
min_mileage.sort()
mileage_sum = 0
answer = 0
for mileage in min_mileage:
    if mileage_sum + mileage <= m:
        mileage_sum += mileage
        answer += 1
    else:
        break
print(answer)