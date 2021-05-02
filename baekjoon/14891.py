from collections import deque

class Gear:
    def __init__(self, init_teeth):
        self.teeth = deque(init_teeth)
    def spin(self, spin_dir):
        if spin_dir == 1:
            self.teeth.appendleft(self.teeth.pop())
        elif spin_dir == -1:
            self.teeth.append(self.teeth.popleft())

def chain_spin(gear_idx, spin_dir, chain_dir):
    global N, gear_list
    gear_now = gear_list[gear_idx]
    chain_idx = gear_idx + chain_dir
    tooth_now = 4 - 2*chain_dir
    tooth_next = 4 + 2*chain_dir
    if (chain_idx >= 0 and chain_idx < N):
        next_gear = gear_list[chain_idx]
        if next_gear.teeth[tooth_next] != gear_now.teeth[tooth_now]:
            next_gear.spin((-1)*spin_dir)
            chain_spin(chain_idx, (-1)*spin_dir, chain_dir)
        else:
            return
    return

N = 4
gear_list = []
ans = 0
for i in range(N):
    gear_list.append(Gear(map(int, list(input()))))
K = int(input())
for j in range(K):
    gear_idx, spin_dir = map(int, input().split())
    gear_idx -= 1
    gear_list[gear_idx].spin(spin_dir)
    chain_spin(gear_idx, spin_dir, -1)
    chain_spin(gear_idx, spin_dir, 1)
for g_idx in range(N):
    ans += gear_list[g_idx].teeth[0]*(2**g_idx)
print(ans)