N = int(input())
distance_list = list(map(int, input().split()))
price_list = list(map(int, input().split()))

pos = 0
min_price_pos = 0
answer = 0

while(pos != len(distance_list)):
    answer += distance_list[pos]*price_list[min_price_pos]
    pos += 1
    if price_list[pos] < price_list[min_price_pos]:
        min_price_pos = pos
print(answer)
