tri_num = [(x*(x+1))//2 for x in range(1, 45)]
three_tri_num = []
for i in tri_num:
    for j in tri_num:
        for k in tri_num:
            num = i + j + k 
            if (num <= 1000):
                three_tri_num.append(num)

T = int(input())
for i in range(T):
    K = int(input())
    print(1 if K in three_tri_num else 0)