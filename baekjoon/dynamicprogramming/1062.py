# def find_max_words(set_list, chr_limit, num_words):
#     if len(set_list) == 0:
#         return num_words
#     set_size = set_list[0][0]
#     set_words = set_list[0][1]
#     if set_size > chr_limit:
#         return find_max_words(set_list[1:], chr_limit, num_words)
#     else:
#         return max(find_max_words(set_list[1:], chr_limit - set_size, num_words + set_words), find_max_words(set_list[1:], chr_limit, num_words))

N, K = map(int, input().split())
if K < 5:
    print(0)
    exit(0)

chr_limit = K - 5
chrset_list = []
answer = 0
for i in range(N):
    chrset = set(input()) - set(['a', 'n', 't', 'i', 'c'])
    if len(chrset) == 0:
        answer += 1
    elif len(chrset) <= chr_limit:
        chrset_list.append(chrset)

coverage_list = []
for i in range(len(chrset_list)):
    num_words = 0
    for chrset in chrset_list:
        if chrset_list[i].issuperset(chrset):
            num_words += 1
    coverage_list.append((len(chrset_list[i]), num_words))
coverage_list.sort(key=lambda x: -x[1]/x[0])
for chosen in coverage_list:
    if coverage_list[0] < chr_limit:
        chr_limit -= coverage_list[0]
        answer += coverage_list
