def solution(phone_book):
    answer = True
    sorted_phonebook = sorted(phone_book)
    for idx in range(len(sorted_phonebook) - 1):
        if len(sorted_phonebook[idx]) < len(sorted_phonebook[idx + 1]) and sorted_phonebook[idx + 1].startswith(sorted_phonebook[idx]):
            answer = False
    return answer

phone_book = ["119", "97674223", "1195524421"]

print(solution(phone_book))