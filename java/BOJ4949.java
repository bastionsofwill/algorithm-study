import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class BOJ4949 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<String> parenthesisStack = new Stack<>();
        ArrayList<String> leftBrackets = new ArrayList<String>();
        leftBrackets.add("(");
        leftBrackets.add("[");
        ArrayList<String> rightBrackets = new ArrayList<String>();
        rightBrackets.add(")");
        rightBrackets.add("]");
        String input, ans;
        while(true) {
            parenthesisStack.clear();
            input = sc.nextLine();
            ans = "yes";
            if(input.equals(".")) break;
            for(int i = 0; i < input.length(); i++) {
                String c = "" + input.charAt(i);
                if(leftBrackets.contains(c)) parenthesisStack.add(c);
                else if(rightBrackets.contains(c)) {
                    if(parenthesisStack.empty()) {
                        ans = "no";
                        break;
                    } else {
                        String lastPar = parenthesisStack.pop();
                        if((c.equals(rightBrackets.get(0)) && lastPar.equals(leftBrackets.get(0))) || (c.equals(rightBrackets.get(1)) && lastPar.equals(leftBrackets.get(1)))) {
                            continue;
                        } else {
                            ans = "no";
                            break;
                        }
                    }

                }
            }
            if(parenthesisStack.empty()) System.out.println(ans);
            else System.out.println("no");
        }
        sc.close();
    }
}