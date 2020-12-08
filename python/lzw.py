lzw_dict = {}
for alphabet in range(26):
    lzw_dict[chr(65 + alphabet)] = alphabet + 1
lzw_next_key = 27

msg = "ABABABABABABABAB"
msg_next_letter = 0
ans = []

for letter_idx in range(len(msg)):
    if letter_idx < msg_next_letter:
        continue
    msg_is_in_dict = True
    for end_idx in range(letter_idx + 1, len(msg) + 1):
        if not(msg[letter_idx:end_idx] in lzw_dict):
            msg_is_in_dict = False
            ans.append(lzw_dict.get(msg[letter_idx:end_idx - 1]))
            lzw_dict[msg[letter_idx:end_idx]] = lzw_next_key
            lzw_next_key += 1
            msg_next_letter = end_idx - 1
            break
    if msg_is_in_dict:
        ans.append(lzw_dict.get(msg[letter_idx:end_idx]))
        letter_idx = end_idx      
print(ans)
