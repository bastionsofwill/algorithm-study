list_sample = [1,2,3,4,5,6,7,8,9]
for idx, val in enumerate(list_sample):
    list_sample[min(idx*2, 8)] = 999
    print(idx, val)