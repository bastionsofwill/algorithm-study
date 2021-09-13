def solution(genres, plays):
    answer = []
    genre_dict = {}
    for i in range(len(genres)):
        g = genres[i]
        p = plays[i]
        if g in genre_dict:
            genre_dict[g][0] += p
            genre_dict[g][1].append((i, p))
        else:
            genre_dict[g] = [p, [(i, p)]]
    for g, p in sorted(genre_dict.items(), key=lambda x: x[1][0], reverse=True):
        songs = (sorted(p[1], key=lambda x: x[1], reverse=True))
        answer.append(songs[0][0])
        if len(songs) > 1:
            answer.append(songs[1][0])
    return answer

genre = ["classic", "pop", "classic", "classic", "pop"]
plays = [500, 600, 150, 800, 2500]
# [4, 1, 3, 0]

print(solution(genre, plays))