from itertools import combinations

def tuple_to_string(t):
    answer = ''
    for c in t:
        answer += c
    return answer

def solution(orders, course):
    answer = []
    order_list = []
    menu_set = set()
    for order in orders:
        order_list.append(set(order))
        menu_set |= set(order)
    menu_list = sorted(list(menu_set))
    for food_num in course:
        combo_list = list(combinations(menu_list, food_num))
        combo_dict = {}
        for c in combo_list:
            c_key = tuple_to_string(c)
            combo_dict[c_key] = 0
            for o in order_list:
                if set(c).issubset(o):
                    combo_dict[c_key] += 1
        combo_items = sorted(combo_dict.items(), key=lambda x: x[1], reverse=True)
        max_ordered_num = 0
        for i in combo_items:
            if i[1] >= max_ordered_num and i[1] > 1:
                max_ordered_num = i[1]
                answer.append(i[0])
            else:
                break
    return sorted(answer)

orders = ["ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"]
course = [2, 3, 4]
print(solution(orders, course))