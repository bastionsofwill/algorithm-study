import java.util.Scanner;

public class BOJ1629 {
    static int pow(int base, int exponent, int divisor) {
        int remainder = base%divisor;
        if(exponent == 1) return remainder;
        long temp = pow(remainder, exponent/2, divisor);
        long evenAns = (temp*temp)%divisor;
        if(exponent%2 == 0) return (int)evenAns;
        else {
            long temp2 = evenAns*remainder;
            return (int)(temp2%divisor);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int base = sc.nextInt();
        int exponent = sc.nextInt();
        int divisor = sc.nextInt();
        System.out.println(pow(base, exponent, divisor));
        sc.close();
    }
}
// 2147483646 2147483647 2147483647