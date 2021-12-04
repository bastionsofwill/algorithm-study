import java.util.Scanner;

public class BOJ2740 {
    public int[][] matMul(int[][] A, int[][] B) {
        int N = A.length;
        int M = A[0].length;
        int K = B[0].length;
        int[][] ans = new int[N][K];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < K; j++) {
                for(int k = 0; k < M; k++) {
                    ans[i][j] += A[i][k]*B[k][j];
                }
            }
        }
        return ans;
    }
    public void printArr(int[][] arr) {
        int R = arr.length;
        int C = arr[0].length;
        for(int r = 0; r < R; r++) {
            for(int c = 0; c < C; c++) {
                if(c != 0) System.out.print(" ");
                System.out.print(arr[r][c]);
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BOJ2740 boj2740 = new BOJ2740();
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] A = new int[N][M];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                A[i][j] = sc.nextInt();
            }
        }
        M = sc.nextInt();
        int K = sc.nextInt();
        int[][] B = new int[M][K];
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < K; j++) {
                B[i][j] = sc.nextInt();
            }
        }
        boj2740.printArr(boj2740.matMul(A, B));
        sc.close();
    }
}
