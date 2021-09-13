def solution(arr1, arr2):
    answer = [[0 for c in range(len(arr2[0]))] for r in range(len(arr1))]
    print(answer)
    for i in range(len(arr1)):
        v1 = arr1[i]
        for j in range(len(arr2[0])):
            v2 = []
            for k in range(len(arr2)):
                v2.append(arr2[k][j])
            new = 0
            for e1, e2 in zip(v1, v2):
                new += e1*e2
            answer[i][j] = new
    return answer

arr1 = [[1, 4], [3, 2], [4, 1]]
arr2 = [[3, 3], [3, 3]]
print(solution(arr1, arr2))