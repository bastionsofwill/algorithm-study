import java.util.Scanner;

public class BOJ9184 {
    public int[][][] cache = new int[21][21][21];
    public BOJ9184() {
        for(int i = 0; i < 21; i++) {
            for(int j = 0; j < 21; j++) {
                for(int k = 0; k < 21; k++) this.cache[i][j][k] = -1;
            }
        }
    }
    public int calculate(int a, int b, int c) {
        int result;
        if(a <= 0 || b <= 0 || c <= 0) return 1;
        if(a > 20 || b > 20 || c > 20) return calculate(20, 20, 20);
        int cachedValue = this.cache[a][b][c];
        if(cachedValue != -1) return cachedValue;
        if(a < b && b < c) {
            result = calculate(a, b, c - 1) + calculate(a, b - 1, c - 1) - calculate(a, b - 1, c);
            cache[a][b][c] = result;
            return result;
        }
        result = calculate(a - 1, b, c) + calculate(a - 1, b - 1, c) + calculate(a - 1, b, c - 1) - calculate(a - 1, b - 1, c - 1);
        cache[a][b][c] = result;
        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BOJ9184 w = new BOJ9184();
        while(true) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            if(a == -1 && b == -1 && c == -1) break;
            System.out.printf("w(%d, %d, %d) = %d%n", a, b, c, w.calculate(a, b, c));
        }
        sc.close();
    }
}
