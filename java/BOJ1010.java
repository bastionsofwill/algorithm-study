import java.util.Scanner;

public class BOJ1010 {
    static long combination(long n, long r) {
        if(r == 1) return n;
        else return(combination(n - 1, r - 1)*n/r);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        for(int tc = 0; tc < T; tc++) {
            long N = sc.nextLong();
            long M = sc.nextLong();
            sc.nextLine();
            System.out.println(combination(M, N));
        }
        sc.close();
    }
}
