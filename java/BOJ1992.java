import java.util.Scanner;

public class BOJ1992 {
    public int getColor(int[][] image) {
        int N = image.length;
        int firstCell = image[0][0];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(image[i][j] != firstCell) return -1;
            }
        }
        return firstCell;
    }
    public int[][] getQuadrantArr(int[][] image, int quadrant) {
        int height = image.length;
        int width = image[0].length;
        int h0, h1, w0, w1;
        if(quadrant < 2) {
            h0 = 0;
            h1 = height/2;
        } else {
            h0 = height/2;
            h1 = height;
        }
        if(quadrant%2 == 0) {
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
                ret[r][c++] = image[i][j];
            }
			r++;
			c = 0;
        }
        return ret;
    }
    public String quadComp(int[][] image) {
        int color = getColor(image);
        if(color != -1) return "" + color;
        String ret = "(";
        for(int q = 0; q < 4; q++) {
            int[][] quadImg = getQuadrantArr(image, q);
            ret += quadComp(quadImg);
        }
        return ret + ")";
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        BOJ1992 boj1992 = new BOJ1992();
        int[][] bitMap = new int[N][N];
        char[] tempArr;
        int cIdx;
        for(int i = 0; i < N; i++) {
            tempArr = sc.nextLine().toCharArray();
            cIdx = 0;
            for(char c: tempArr) bitMap[i][cIdx++] = (c - '0');
        }
        sc.close();
        System.out.println(boj1992.quadComp(bitMap));        
    }
}
