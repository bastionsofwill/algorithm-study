C = int(input())
triangle = []
cache = []
def max_triangle_sum(r, c, h):
    if cache[r][c]:
        return cache[r][c]
    elif r == (h - 1):
        return triangle[r][c]
    elif c == (h - 1):
        cache[r][c] = triangle[r][c] + max_triangle_sum(r + 1, c, h)
        return cache[r][c]
    else:
        cache[r][c] = triangle[r][c] + max(max_triangle_sum(r + 1, c, h), max_triangle_sum(r + 1, c + 1, h))
    return cache[r][c]
    
for i in range(C):
    triangle = []
    h = int(input())
    cache = [[False]*h for _ in range(h)]
    for j in range(h):
        triangle.append(list(map(int, input().split())))
    print(max_triangle_sum(0, 0, h))