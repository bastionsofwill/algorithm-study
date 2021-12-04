import java.util.Scanner;

public class BOJ10830 {
    public int[][] matMul(int[][] A, int[][] B) {
        int N = A.length;
        int[][] ans = new int[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                for(int k = 0; k < N; k++) {
                    ans[i][j] += A[i][k]*B[k][j];
                }
            }
        }
        return ans;
    }
    public void matMod(int[][] matrix) {
        int N = matrix.length;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                matrix[i][j] %= 1000;
            }   
        }
    }
    public int[][] matPow(int[][] matrix, long B) {
        matMod(matrix);
        if(B == 1) return matrix;
        int[][] ans = matPow(matrix, B/2);
        ans = matMul(ans, ans);
        matMod(ans);
        if(B%2 == 0) return ans;
        ans = matMul(ans, matrix);
        matMod(ans);
        return ans;
    }
    public void printSqArr(int[][] arr) {
        int N = arr.length;
        for(int r = 0; r < N; r++) {
            for(int c = 0; c < N; c++) {
                if(c != 0) System.out.print(" ");
                System.out.print(arr[r][c]);
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long B = sc.nextLong();
        int[][] matrix = new int[N][N];
        for(int i = 0 ; i < N; i++) {
            for(int j = 0; j < N; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        sc.close();
        BOJ10830 boj10830 = new BOJ10830();
        boj10830.printSqArr(boj10830.matPow(matrix, B));
    }
}