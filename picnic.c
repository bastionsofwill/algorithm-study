#include <stdio.h>

int C;
int n;
int m;
int is_friend_of[10][10];
int is_occupied[10];
int g_ans = 0;

int find_next(int src, int dst) {
    if (src + 1 == dst) {
        return src + 2;
    }
    return src + 1;
}

void match_friends(int src, int num_left)
{
    size_t i;
    if (num_left == 2) {
        if (is_friend_of[src][dst] == 1) {
            g_ans++;
            return;
        }
        return;
    }
    else {
        for (i = src + 1; i < n; i++) {
            if (is_friend_of[src][i] == 1) {

                match_friends(find_next(src, i), num_left - 2);
            }
        }
    }
    return;
}

int main(void) {
    
    scanf(&C);
    for (i = 0; i < C; i++) {
        g_ans = 0;
        is_friend_of = { 0, };
        is_occupied = {0,}; /*Initiation*/
        scanf(&n, &m);
        for (j = 0; j < m; j++) {
            scanf(&src, &dst);
            is_friend_of[src][dst] = 1;
        }
        match_friends(0, n);
        printf(%d, g_ans);
    }
    return 0;
}
