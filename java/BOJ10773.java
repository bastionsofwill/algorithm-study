import java.util.Scanner;
import java.util.Stack;

public class BOJ10773 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> ledger = new Stack<>();
        int ans = 0;
        int K = sc.nextInt();
        for(int i = 0; i < K; i++) {
            int num = sc.nextInt();
            if(num == 0) ledger.pop();
            else ledger.push(num);
        }
        while(!ledger.isEmpty()) ans += ledger.pop();
        System.out.println(ans);
        sc.close();
    }
}
