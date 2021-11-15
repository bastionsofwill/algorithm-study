doc = input()
keyword = input()
i = 0
answer = 0
key_len = len(keyword)

while i < len(doc):
    if doc[i:i + key_len] == keyword:
        answer += 1
        i += key_len
    else:
        i += 1
print(answer)