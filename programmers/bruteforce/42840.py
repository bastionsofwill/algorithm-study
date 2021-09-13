def solution(answers):
    answer = []
    num_problem = len(answers)
    dumb_list = []
    score = {1: 0, 2: 0, 3: 0}
    dumb_list.append([1, 2, 3, 4, 5]*(num_problem//5 + 1))
    dumb_list.append([2, 1, 2, 3, 2, 4, 2, 5]*(num_problem//8 + 1))
    dumb_list.append([3, 3, 1, 1, 2, 2, 4, 4, 5, 5]*(num_problem//10 + 1))
    for p_idx in range(num_problem):
        for d_idx in range(3):
            if answers[p_idx] == dumb_list[d_idx][p_idx]:
                score[d_idx + 1] += 1
    score = sorted(score.items(), key=lambda x: -x[1])
    answer.append(score[0][0])
    for i in range(1, 3):
        if score[0][1] == score[i][1]:
            answer.append(score[i][0])    
    return answer