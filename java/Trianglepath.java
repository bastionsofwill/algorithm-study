import java.util.Scanner;

public class Trianglepath {
    public static int[][] triangle = new int[100][100];
    public static int[][] maxSum = new int[100][100];
    public static int findMaxSumPath(int height, int r, int c) {
        if(height == 1) return triangle[r][c];
        if(maxSum[r][c] != -1) return maxSum[r][c];
        maxSum[r][c] = triangle[r][c] + Math.max(findMaxSumPath(height - 1, r + 1, c), findMaxSumPath(height - 1, r + 1, c + 1));
        return maxSum[r][c];
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for(int testcase = 0; testcase < T; testcase++) {
            int height = scanner.nextInt();
            for(int i = 0; i < height; i++) {
                for(int j = 0; j < i + 1; j++) {
                    maxSum[i][j] = -1;
                }
            }
            for(int r = 0; r < height; r++) {
                for(int c = 0; c < r + 1; c++) {
                    triangle[r][c] = scanner.nextInt();
                }
            }
            System.out.println(findMaxSumPath(height, 0, 0));
        }
        scanner.close();
    }
} 
