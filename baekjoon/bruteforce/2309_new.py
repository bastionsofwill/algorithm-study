height_list = []
for i in range(9):
    height_list.append(int(input()))
height_list.sort()

surplus_height = sum(height_list) - 100
fd1 = 0
fd2 = 0
for i in range(9):
    h1 = height_list[i]
    for j in range(i+1, 9):
        h2 = height_list[j]
        if  h1 + h2 == surplus_height:
            fd1 = h1
            fd2 = h2
            break;
    if fd1 != 0:
        break;
for i in height_list:
    if i not in (fd1, fd2):
        print(i)