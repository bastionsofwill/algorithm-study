def solution(phone_book):
    phone_book.sort()
    for i in range(len(phone_book) - 1):
        num_now = phone_book[i]
        num_next = phone_book[i + 1]
        if len(num_now) >= len(num_next):
            continue
        else:
            if num_now == num_next[:len(num_now)]:
                return False
    return True

phone_book = ["12","123","1235","567","88"]
print(solution(phone_book))