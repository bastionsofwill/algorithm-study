global ans
ans = 0

def shoot(target_status, n):
    if n == 0:
        ans += 1
    else:
        for i in range(11):
            target_status[10 - i] += 1
            shoot(target_status, n - 1)
            target_status[10 - i] -=1

shoot([0 for x in range(11)], 5)
print(ans)