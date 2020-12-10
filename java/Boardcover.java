import java.util.Scanner;

public class Boardcover {
    public static void printBoard(boolean[][] gameBoard) {
        for(boolean[] row : gameBoard) {
            for(boolean el : row) {
                if(el) System.out.print(".");
                else System.out.print("#");
            }
            System.out.println();
        }
    }
    public static int[] findNextSrc(boolean[][] gameBoard) {
        int[] nextSrc = new int[2];
        for(int r = 0; r < gameBoard.length - 1; r++) {
            for(int c = 0; c < gameBoard[0].length - 1; c++) {
                if(gameBoard[r][c]) {
                    nextSrc[0] = r;
                    nextSrc[1] = c;
                    System.out.println("newsrc: " + r + " " + c);
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
            if(gameBoard[r + block[0][0]][c + block[0][1]] && gameBoard[r + block[1][0]][c + block[1][1]]) {
                newBoard[r + block[0][0]][c + block[0][1]] = false;
                newBoard[r + block[1][0]][c + block[1][1]] = false;
                printBoard(newBoard);
                ans += recursiveCover(newBoard, numEmpty - 3);
                newBoard[r + block[0][0]][c + block[0][1]] = true;
                newBoard[r + block[1][0]][c + block[1][1]] = true;
            }
        }
        newBoard[r][c] = true;        
        return ans;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = Integer.parseInt(scanner.nextLine());
        int H, W, r, c;
        int numEmpty = 0;
        String[] boardSize;
        for(int testcase = 0; testcase < T; testcase++) {
            boardSize = scanner.nextLine().split(" ");
            H = Integer.parseInt(boardSize[0]);
            W = Integer.parseInt(boardSize[1]);
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
