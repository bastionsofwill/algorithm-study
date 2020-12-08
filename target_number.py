def solution(numbers, target):
    if not numbers and target == 0:
        return 1
    elif not numbers:
        return 0
    else:
        return solution(numbers[1:], target - numbers[0]) + solution(numbers[1:], target + numbers[0])

numbers = [1,1,1,1,1]
target = 3

print(solution(numbers, target))