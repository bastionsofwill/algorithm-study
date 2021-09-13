def solution(brown, yellow):
    answer = []
    area = brown + yellow
    for height in range(1, int(area**0.5) + 1):
        if area%height == 0 and (area//height - 2)*(height - 2) == yellow:
            answer.append(area//height)
            answer.append(height)
    return answer

print(solution(8, 1))