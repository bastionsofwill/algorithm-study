r, c, w, s = map(int, input().split())

if s >= w*2:
    print((r+c)*w)
elif s < w:
    diag_distance = (r + c)//2 + abs(r - c)//2
    print(diag_distance*s + (r + c)%2*w)
else:
    diag_distance = min(r, c)
    print(diag_distance*s + abs(r - c)*w)