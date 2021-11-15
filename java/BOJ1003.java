import java.util.Scanner;
import java.io.IOException;

public class BOJ1003 {
    public static int[] fibResult = new int[41];
    public static int fib(int num) {
        if(num < 0) return 0;
        if(num < 2) return num;
        if(fibResult[num] != 0) return fibResult[num];
        else fibResult[num] = fib(num - 2) + fib(num - 1);
        return fibResult[num];
    }
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        fibResult[1] = 1;
        fib(40);
        for(int i = 0; i < T; i++) {
            int N = Integer.parseInt(sc.nextLine());
            if(N == 0) System.out.println("1 0");
            else System.out.println(fibResult[N - 1] + " " + fibResult[N]);
        }
        sc.close();
    }
}
