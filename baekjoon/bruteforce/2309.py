def find_false_dwarf(picked_dwarves, unpicked_idx):
    if sum(picked_dwarves) == surplus_height and len(picked_dwarves) == 2:
        return picked_dwarves
    elif len(picked_dwarves) < 2:
        for i in range(unpicked_idx, 9):
            res = find_false_dwarf(picked_dwarves + [height_list[i]], i + 1)
            if res:
                return res

height_list = []
for i in range(9):
    height_list.append(int(input()))
height_list.sort()
surplus_height = sum(height_list) - 100
false_dwarf_list = find_false_dwarf([], 0)
for dwarf in height_list:
    if dwarf not in false_dwarf_list:
        print(dwarf)