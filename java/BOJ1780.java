import java.util.Scanner;

public class BOJ1780 {
    public int[] colorCount;
    public BOJ1780() {
        colorCount = new int[3];
    }
    public int getColor(int[][] image) {
        int N = image.length;
        int firstCell = image[0][0];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(image[i][j] != firstCell) return -2;
            }
        }
        return firstCell;
    }
    public int[][] getNineArr(int[][] image, int region) {
        int height = image.length;
        int width = image[0].length;
        int h0, h1, w0, w1;
        if(region < 3) {
            h0 = 0;
            h1 = height/3;
        } else if(region < 6) {
            h0 = height/3;
            h1 = 2*height/3;
        } else {
            h0 = 2*height/3;
            h1 = height;
        }
        if(region%3 == 0) {
            w0 = 0;
            w1 = width/3;
        } else if(region%3 == 1) {
            w0 = width/3;
            w1 = 2*width/3;
        } else {
            w0 = 2*width/3;
            w1 = width;
        }
        int[][] ret = new int[height/3][width/3];
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
    public void nineComp(int[][] image) {
        int color = getColor(image);
        // System.out.println(color);
        if(color != -2) {
            this.colorCount[color + 1]++;
            return;
        }
        for(int q = 0; q < 9; q++) {
            int[][] nineImg = getNineArr(image, q);
            nineComp(nineImg);
        }
        return;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        BOJ1780 boj1780 = new BOJ1780();
        int[][] bitMap = new int[N][N];
        String[] tempArr;
        int cIdx;
        for(int i = 0; i < N; i++) {
            tempArr = sc.nextLine().split(" ");
            cIdx = 0;
            for(String s: tempArr) bitMap[i][cIdx++] = Integer.parseInt(s);
        }
        sc.close();
        boj1780.nineComp(bitMap);
        for(int e: boj1780.colorCount) System.out.println(e);        
    }
}
