input_str = input()
input_list = sorted(map(int, input_str.split()))

interval_0 = input_list[1] - input_list[0]
interval_1 = input_list[2] - input_list[1]

if interval_0 < interval_1:
    print(int(input_list[1] + input_list[2])/2)
elif interval_0 > interval_1:
    print(int(input_list[0] + input_list[1])/2)
else:
    print(input_list[2] + interval_1)