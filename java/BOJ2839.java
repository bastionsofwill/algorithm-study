import java.util.Scanner;

public class BOJ2839 {
    public static int[] cache = new int[5001];
    public static int findNumOfBags(int N) {
        if(N == 0) return 0;
        if(N < 3) return -1;
        if(cache[N] != 0) return cache[N];
        int temp;
        if(findNumOfBags(N - 5) == -1) {
                temp = findNumOfBags(N - 3) + 1;
                if(temp == 0) {
                    cache[N] = -1;
                    return -1;
                } 
        } else temp = findNumOfBags(N - 5) + 1;
        cache[N] = temp;
        return temp;   
    }  
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.close();
        System.out.println(findNumOfBags(N));
    }
}
