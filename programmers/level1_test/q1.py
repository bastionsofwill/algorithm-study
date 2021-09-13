from collections import deque

def solution(cacheSize, cities):
    if cacheSize == 0:
        return 5*len(cities)
    answer = 0
    cache = deque()
    for city in cities:
        city = city.upper()
        if city in cache:
            answer += 1
            cache.remove(city)
            cache.append(city)
        else:
            answer += 5
            if len(cache) == cacheSize:
                cache.popleft()
            cache.append(city)               
    return answer


cacheSize = 3
cities = ["Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"]

print(solution(cacheSize, cities))