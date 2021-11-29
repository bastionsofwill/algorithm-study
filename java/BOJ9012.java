import java.util.Scanner;
import java.util.Stack;

public class BOJ9012 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Character> parenthesisStack = new Stack<>();
        String PS, ans;
        int T = sc.nextInt();
        sc.nextLine();
        for(int tc = 0; tc < T; tc++) {
            PS = sc.nextLine();
            parenthesisStack.clear();
            ans = "YES";
            for(int i = 0; i < PS.length(); i++) {
                char p = PS.charAt(i);
                if(p == '(') {
                    parenthesisStack.push(p);
                } else {
                    if(parenthesisStack.empty()) {
                        ans = "NO";
                        break;
                    }
                    char lastPar = parenthesisStack.pop();
                    if(lastPar == '(') continue;
                    else {
                        ans = "NO";
                        break;
                    }
                }
            }
            if(parenthesisStack.empty()) System.out.println(ans);
            else System.out.println("NO");
        }
        sc.close();
    }
}