import java.util.Scanner;

public class BOJ1002 {
    public static void findPos(String[] inputStr) {
        int dx = Integer.parseInt(inputStr[0]) - Integer.parseInt(inputStr[3]);
        int dy = Integer.parseInt(inputStr[1]) - Integer.parseInt(inputStr[4]);
        int r1 = Integer.parseInt(inputStr[2]);
        int r2 = Integer.parseInt(inputStr[5]);
        double dSquare = Math.pow(dx, 2) + Math.pow(dy, 2);
        double rsumSquare = Math.pow(r1 + r2, 2);
        double rdiffSquare = Math.pow(r1 - r2, 2);
        if(dSquare > rsumSquare) {
            System.out.println(0);
        } else if(dSquare == rsumSquare) {
            System.out.println(1);
        } else {
            if(dSquare < rdiffSquare) {
                System.out.println(0);
            } else if(dSquare == rdiffSquare) {
                if(dSquare == 0) {
                    System.out.println(-1);
                } else System.out.println(1);
            } else {
                System.out.println(2);
            }
        }
        return;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        for(int i = 0; i < T; i++) {
            findPos(sc.nextLine().split(" "));
        }
        sc.close();
    }
}