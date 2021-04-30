C = int(input())
brackets = {')': '(', '}': '{', ']': '['}

for i in range(C):
    input_list = list(input())
    is_legit = True
    bracket_stack = []
    for bracket in input_list:
        if bracket in brackets.values():
            bracket_stack.append(bracket)
        else:
            if len(bracket_stack) == 0:
                is_legit = False
                break
            elif bracket_stack.pop() != brackets[bracket]:
                is_legit = False
                break
    if len(bracket_stack) != 0:
        is_legit = False
    print('YES' if is_legit else 'NO')