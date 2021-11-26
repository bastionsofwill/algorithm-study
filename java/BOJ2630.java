import java.util.Scanner;

public class BOJ2630 {
    public int getColor(int[][] paper) {
        int N = paper.length;
        int firstCell = paper[0][0];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(paper[i][j] != firstCell) return -1;
            }
        }
        return firstCell;
    }
    public int[][] getQuadrantArr(int[][] paper, int quadrant) {
        int height = paper.length;
        int width = paper[0].length;
        int h0, h1, w0, w1;
        if(quadrant < 3) {
            h0 = 0;
            h1 = height/2;
        } else {
            h0 = height/2;
            h1 = height;
        }
        if(quadrant == 2 || quadrant == 3) {
            w0 = 0;
            w1 = width/2;
        } else {
            w0 = width/2;
            w1 = width;
        }
        int[][] ret = new int[height/2][width/2];
		int r = 0;
		int c = 0;
        for(int i = h0; i < h1; i++) {
            for(int j = w0; j < w1; j++) {
                ret[r][c++] = paper[i][j];
            }
			r++;
			c = 0;
        }
        return ret;
    }
    public int[] countArea(int[][] paper) {
        int color = getColor(paper);
        if(color == -1) {
            int[] ans1 = countArea(getQuadrantArr(paper, 1));
            int[] ans2 = countArea(getQuadrantArr(paper, 2));
            int[] ans3 = countArea(getQuadrantArr(paper, 3));
            int[] ans4 = countArea(getQuadrantArr(paper, 4));
            int white = ans1[0] + ans2[0] + ans3[0] + ans4[0];
            int blue = ans1[1] + ans2[1] + ans3[1] + ans4[1];
            int[] ans = {white, blue};
            return ans;
        } else if(color == 1) {
            int[] ans = {0, 1};
            return ans;
        } else {
            int [] ans = {1, 0};
            return ans;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] paper = new int[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                paper[i][j] = sc.nextInt();
            }
        }
        BOJ2630 main = new BOJ2630();
        int[] ans = main.countArea(paper);
        System.out.println(ans[0]);
        System.out.println(ans[1]);
        sc.close();
    }
}
