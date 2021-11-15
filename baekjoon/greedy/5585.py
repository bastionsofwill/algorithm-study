change = 1000 - int(input())
coins = [500, 100, 50, 10, 5, 1]
i = 0
num_coin = 0
answer = 0

while(change != 0):
    num_coin = change // coins[i]
    if num_coin > 0:
        change -= num_coin*coins[i]
        answer += num_coin
    i += 1
print(answer)