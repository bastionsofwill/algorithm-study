filename_list = []
cache = []

def compare_str(s1, s2):
    if cache[len(s1)][len(s2)] != -1:
        return cache[len(s1)][len(s2)]
    if s1 == '*':
        cache[len(s1)][len(s2)] = True
        return True
    elif len(s1) == 0:
        cache[len(s1)][len(s2)] = (len(s2) == 0)
        return len(s2) == 0
    elif len(s2) == 0:
        cache[len(s1)][len(s2)] = False
        return False
    l1 = s1[0]
    l2 = s2[0]
    if l1 == '*':
        cache[len(s1)][len(s2)] = compare_str(s1[1:], s2) or compare_str(s1, s2[1:])
        return cache[len(s1)][len(s2)]
    elif l1 == '?' or l1 == l2:
        cache[len(s1)][len(s2)] = compare_str(s1[1:], s2[1:])
        return cache[len(s1)][len(s2)]
    else:
        cache[len(s1)][len(s2)] = False
        return False

C = int(input())
for i in range(C):
    filename_list = []
    wildcard_string = input()
    file_cnt = int(input())
    for j in range(file_cnt):
        filename_list.append(input())
    for filename in sorted(filename_list):
        cache = [[-1]*(len(filename) + 1) for _ in range(len(wildcard_string) + 1)]
        if compare_str(wildcard_string, filename):
            print(filename)