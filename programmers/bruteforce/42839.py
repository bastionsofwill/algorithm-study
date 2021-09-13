def pick_num(freq, n, start):
    picked_num = []
    if n == 1:
        for i in range(start, len(freq)):
            if freq[i] != 0:
                picked_num.append(str(i))
        return picked_num
    else:
        for i in range(start, len(freq)):
            if freq[i] != 0:
                freq[i] -= 1
                for j in pick_num(freq, n - 1, i):
                    picked_num.append(str(i) + j)
                freq[i] += 1
        return picked_num             

def find_anagram(string):
    if len(string) == 0:
        return ['']
    elif len(string) == 1:
        return [string]
    else:
        anagrams = set()
        for c in range(len(string)):
            for excluded_anagrams in find_anagram(string[:c] + string[c+1:]):
                anagrams.add(string[c] + excluded_anagrams)
        return list(anagrams)

def is_prime(num):
    if num < 2:
        return False
    for i in range(2, int(num**0.5) + 1):
        if num%i == 0:
            return False
    return True
     
def solution(numbers):
    picks = []
    cases = []
    freq = [0 for x in range(10)]
    for number in list(map(int, sorted(list(numbers)))):
        freq[number] += 1
    answer = 0
    for i in range(len(numbers)):
        picks += pick_num(freq, i + 1, 0)
    for pick in picks:
        cases += find_anagram(pick)
    cases = set(map(int, cases))
    for case in cases:
        if case > 1 and is_prime(case):
            answer += 1
    return answer

print(solution('1234567'))