def seperate_digits(num):
    return (num//100, (num%100)//10, num%10)

def find_strike_digits(target, guess):
    t = seperate_digits(target)
    g = seperate_digits(guess)
    return (t[0] == g[0], t[1] == g[1], t[2] == g[2])

def find_ball_digits(target, guess):
    t_digits = seperate_digits(target)
    g_digits = seperate_digits(guess)
    b0 = g_digits[0] in (t_digits[1], t_digits[2])
    b1 = g_digits[1] in (t_digits[2], t_digits[0])
    b2 = g_digits[2] in (t_digits[0], t_digits[1])
    return (b0, b1, b2)

def is_three_o(s):
    return (s[0] and s[1] and s[2])

def is_two_o_one_x(s):
    s1, s2, s3 = s
    if not (s1 or s2):
        return False
    if not (s2 or s3):
        return False
    if not (s3 or s1):
        return False
    if s1 and s2 and s3:
        return False
    return True

def is_one_o_two_x(s):
    s1, s2, s3 = s
    if s1 and s2:
        return False
    if s2 and s3:
        return False
    if s3 and s1:
        return False
    if not (s1 or s2 or s3):
        return False
    return True

def is_three_x(s):
    return not (s[0] or s[1] or s[2])

N = int(input())
hint_list = []
candidate_list = [1 for x in range(1000)]
function_list = [is_three_x, is_one_o_two_x, is_two_o_one_x, is_three_o]

for i in range(1000):
    digits = seperate_digits(i)
    if digits[0] == 0 or digits[1] == 0 or digits[2] == 0:
        candidate_list[i] = 0
    if digits[0] == digits[1] or digits[1] == digits[2] or digits[2] == digits[0]:
        candidate_list[i] = 0

for i in range(N):
    number, strike, ball = map(int, input().split())
    hint_list.append((number, strike, ball))

for hint in hint_list:
    num = hint[0]
    s = hint[1]
    b = hint[2]
    if s == 3:
        candidate_list = [0 for x in range(1000)]
        candidate_list[num] = 1
        break
    candidate_list[num] = 0
    for i in range(123, 988):
        if not function_list[s](find_strike_digits(num, i)):
            candidate_list[i] = 0
        if not function_list[b](find_ball_digits(num, i)):
            candidate_list[i] = 0

print(sum(candidate_list))