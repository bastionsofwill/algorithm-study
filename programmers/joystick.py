def find_chr_distance(c):
    return min(ord(c) - ord('A'), ord('Z') - ord(c) + 1)

def solution(name):
    longestA_idx = 0
    longestA_len = 0
    tempA_idx = 0
    tempA_len = 0
    seqA_flag = 0
    for i in range(len(name)):
        if name[i] == 'A' and not seqA_flag:
            tempA_idx = i
            tempA_len = 1
            seqA_flag = 1
        elif name[i] == 'A' and seqA_flag:
            tempA_len += 1
        elif seqA_flag:
            if tempA_len > longestA_len:
                longestA_len = tempA_len
                longestA_idx = tempA_idx
            seqA_flag = 0
    answer = 0
    for c in range(longestA_idx):
        answer += find_chr_distance(name[c])
    answer += 2*(longestA_idx - 1)
    
    for c_r in range(len(name) - 1, longestA_idx + longestA_len - 1, -1):
        answer += 1
        answer += find_chr_distance(name[c_r])
    return answer
    
print(solution('JAAROITJREITAAAERS'))
# for i in range(65, 91):
#     print(find_chr_distance(chr(i)))