def count_s_b(num1, num2):
    s = 0
    b = 0
    for i in range(3):
        if num1[i] == num2[i]:
            s += 1
        elif num1[i] == num2[(i+1)%3] or num1[i] == num2[(i+2)%3]:
            b += 1
    return (s, b)

def is_suspect(guess_list, suspect):
    for guess_num, guess_s, guess_b in guess_list:
        s, b = count_s_b(guess_num, suspect)
        if int(guess_s) != s or int(guess_b) != b:
            return False
    return True

def is_legit(num):
    n_100 = num//100
    n_10 = (num%100)//10
    n_1 = num%10
    if n_100 == 0 or n_10 == 0 or n_1 == 0:
        return False
    elif n_100 == n_10 or n_10 == n_1 or n_1 == n_100:
        return False
    return True

N = int(input())
guess_list = [tuple(input().split()) for i in range(N)]
suspect_num = 0

for i in range(123, 988):
    if not is_legit(i):
        continue
    if is_suspect(guess_list, str(i)):
        suspect_num += 1

print(suspect_num)