import java.util.Scanner;
import java.util.Stack;
import java.io.IOException;

public class BOJ1874 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();
        int ascIdx = 1;
        Stack<Integer> s = new Stack<Integer>();
        for(int i = 1; i <= N; i++) {
            int num = sc.nextInt();
            while(ascIdx <= num) {
                sb.append("+\n");
                s.push(ascIdx++);
            }
            if(num == s.pop()) {
                sb.append("-\n");
            } else {
                System.out.println("NO");
                sc.close();
                return;
            }
        }
        System.out.print(sb);
        sc.close();
    }
}