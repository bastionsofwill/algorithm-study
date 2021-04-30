import java.util.Scanner;

public class LIS {
    public static int findLIS(int[] sequence) {
        int LIS = 1;
        int prev = sequence[0];
        int IS = 1;
        for(int i = 1; i < sequence.length; i++) {
            if(sequence[i] > prev) {
                if(++IS > LIS) LIS = IS;
            } else IS = 1;
            prev = sequence[i];
        }
        return LIS;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for(int testcase = 0; testcase < T; testcase++) {
            int N = scanner.nextInt();
            int[] sequence = new int[N];
            for(int i = 0; i < N; i++) {
                sequence[i] = scanner.nextInt();
            }
            System.out.println(findLIS(sequence));
        }
        scanner.close();
    }
}
