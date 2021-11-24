import java.util.Scanner;

public class BOJ1012 {
    public int N, M;
    public boolean[][] field;
    public BOJ1012(int N, int M, boolean[][] f) {
        this.N = N;
        this.M = M;
        this.field = f;
    }
    public void eatPest(int r, int c) {
        this.field[r][c] = false;
        if(r - 1 >= 0 && this.field[r - 1][c]) eatPest(r - 1, c);
        if(r + 1 < N && this.field[r + 1][c]) eatPest(r + 1, c);
        if(c - 1 >= 0 && this.field[r][c - 1]) eatPest(r, c - 1);
        if(c + 1 < M && this.field[r][c + 1]) eatPest(r, c + 1);
    }
    public int countWorm() {
        int ans = 0;
        for(int r = 0; r < this.N; r++) {
            for(int c = 0; c < this.M; c++) {
                if(field[r][c]) {
                    ans++;
                    eatPest(r, c);
                } 
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean[][] field;
        int T = sc.nextInt();
        int N, M, K, x, y;
        for(int tc = 0; tc < T; tc++) {
            N = sc.nextInt();
            M = sc.nextInt();
            K = sc.nextInt();
            field = new boolean[N][M];
            for(int i = 0; i < K; i++) {
                x = sc.nextInt();
                y = sc.nextInt();
                field[x][y] = true;
            }
            BOJ1012 cabbagePatch = new BOJ1012(N, M, field);
            System.out.println(cabbagePatch.countWorm());
        }
        sc.close();
    }
}
