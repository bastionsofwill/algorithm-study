import java.util.Scanner;

public class Boggle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        String row = scanner.nextLine();
        String[][] gameBoard = new String[5][5];
        for(int testCase = 0; testCase < T; testCase++) {
            for(int i = 0; i < 5; i++) {
                row = scanner.nextLine();
                String[] splitedRow = row.split("");
                for(int j = 0; j < 5; j++) {
                    gameBoard[i][j] = splitedRow[j];
                }
            }
            int numWords = scanner.nextInt();
            String word = scanner.nextLine();
            String[] wordList = new String[numWords]; 
            for(int k = 0; k < numWords; k++) {
                word = scanner.nextLine();
                wordList[k] = word;                
            }
            
        }
        scanner.close();
    }
}