s = input()
formula_list = []
num_str = ''
for c in s:
    if ord(c) > 47 and ord(c) < 58:
        num_str += c
    else:
        formula_list.append(int(num_str))
        formula_list.append(c)
        num_str = ''
formula_list.append(int(num_str))   

temp_sum = 0
minus_flag = 0
answer = 0
for e in formula_list:
    if minus_flag == 0 and type(e) == int:
        temp_sum += e
    elif type(e) == int:
        temp_sum -= e
    elif e == '-':
        answer += temp_sum
        temp_sum = 0
        minus_flag = 1
answer += temp_sum
print(answer)
