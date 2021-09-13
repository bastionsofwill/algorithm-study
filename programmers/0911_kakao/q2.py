def is_prime(num):
    if num == 2:
        return True
    for i in range(2, int(num**1/2) + 1):
        if num%i == 0:
            return False
    return True

def convert(num, base) :
    q, r = divmod(num, base)
    if q == 0 :
        return str(r)
    else :
        return convert(q, base) + str(r)

def solution(n, k):
    num_list = []
    for s in convert(n, k).split('0'):
        if len(s) != 0:
            num_list.append(int(s))
    answer = 0
    for num in num_list:
        if num > 1 and is_prime(num):
            answer += 1
    return answer

n = 123456
k = 10
print(solution(n, k))