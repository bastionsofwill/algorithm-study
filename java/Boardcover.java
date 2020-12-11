import java.util.Scanner;

public class Boardcover {
    public static int[] findNextSrc(boolean[][] gameBoard) {
        int[] nextSrc = new int[2];
        for(int r = 0; r < gameBoard.length; r++) {
            for(int c = 0; c < gameBoard[0].length; c++) {
                if(gameBoard[r][c]) {
                    nextSrc[0] = r;
                    nextSrc[1] = c;
                    System.out.println("nextSrc: " + r + " " + c);
                    return nextSrc;
                }
            }
        }
        return null;
    }
    public static int recursiveCover(boolean[][] gameBoard, int numEmpty) {
        if(numEmpty == 0) return 1;
        if(numEmpty%3 != 0) return 0;
        int ans = 0;
        boolean[][] newBoard = gameBoard.clone();
        int[] nextSrc = findNextSrc(gameBoard);
        int r = nextSrc[0];
        int c = nextSrc[1];
        int[][][] delta = {{{1, 0}, {0, 1}},
                           {{1, 0}, {1, -1}},
                           {{1, 0}, {1, 1}},
                           {{0, 1}, {1, 1}}};
        newBoard[r][c] = false;
        for(int[][] block : delta) {
            int nr0 = r + block[0][0];
            int nc0 = c + block[0][1];
            int nr1 = r + block[1][0];
            int nc1 = c + block[1][1];
            boolean isIndexOutOfBound = (nr0 < 0 || nc0 < 0 || nr1 < 0 || nc1 < 0 || nr0 >= gameBoard.length || nc0 >= gameBoard[0].length || nr1 >= gameBoard.length || nc1 >= gameBoard[0].length) ? true : false;
            if(!isIndexOutOfBound && gameBoard[nr0][nc0] && gameBoard[nr1][nc1]) {
                newBoard[nr0][nc0] = false;
                newBoard[nr1][nc1] = false;
                ans += recursiveCover(newBoard, numEmpty - 3);
                newBoard[nr0][nc0] = true;
                newBoard[nr1][nc1] = true;   
            }
        }
        newBoard[r][c] = true;        
        return ans;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        int H, W, r, c;
        int numEmpty = 0;
        for(int testcase = 0; testcase < T; testcase++) {
            H = scanner.nextInt();
            W = scanner.nextInt();
            scanner.nextLine();
            boolean[][] gameBoard = new boolean[H][W];
            for(r = 0; r < H; r++) {
                char[] row = scanner.nextLine().toCharArray();
                for(c = 0; c < W; c++) {
                    if(row[c] == '.') {
                        gameBoard[r][c] = true;
                        numEmpty++;
                    }
                }
            }
            System.out.println(recursiveCover(gameBoard, numEmpty));
            numEmpty = 0;          
        }
        scanner.close();
    }
}
