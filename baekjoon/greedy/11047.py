N, K = map(int, input().split())
coins = []
coin_idx = 0
price = 0
answer = 0

for i in range(N):
    coins.append(int(input()))
coins = sorted(coins, key=lambda x: -x)

while (price != K):
    coin_num = ((K - price) // coins[coin_idx])
    if coin_num == 0:
        coin_idx += 1
    else:
        price += coins[coin_idx]*coin_num
        answer += coin_num
print(answer)