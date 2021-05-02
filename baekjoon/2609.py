input_list = sorted(map(int, input().split()))
gcd = -1

while True:
    remainder = input_list[1]%input_list[0]
    if remainder == 0:
        gcd = input_list[0]
        break
    else:
        input_list.pop()
        input_list = [remainder] + input_list
print(gcd)
lcm = (input_list[0]//gcd)*input_list[1]
print(lcm)