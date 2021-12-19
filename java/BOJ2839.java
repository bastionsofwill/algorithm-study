import java.util.Scanner;

public class BOJ2839 {
    public static int[] cache = new int[5001];
    public static int findNumOfBags(int N) {
        if(N == 0) return 0;
        if(N < 3) return -1;
        if(cache[N] != 0) return cache[N];
        int ans;
        if(findNumOfBags(N - 5) == -1) {
                ans = findNumOfBags(N - 3) + 1;
                if(ans == 0) {
                    cache[N] = -1;
                    return -1;
                } 
        } else ans = findNumOfBags(N - 5) + 1;
        cache[N] = ans;
        return ans;
    }  
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.close();
        System.out.println(findNumOfBags(N));
    }
}
