import java.util.Scanner;
import java.util.Stack;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

public class BOJ17298 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Integer> toDo = new Stack<Integer>();
        Stack<Integer> greaterInts = new Stack<Integer>();
        Stack<Integer> ans = new Stack<Integer>();
        sc.nextLine();
        String[] inputArr = sc.nextLine().split(" ");
        sc.close();
        List<Integer> input = Arrays.stream(inputArr).map(e -> Integer.parseInt(e)).collect(Collectors.toList());
        for(int e: input) toDo.push(e);
        while(!toDo.empty()) {
            int eNow = toDo.pop();
            while(!greaterInts.empty()) {
                int eLast = greaterInts.peek();
                if(eNow < eLast) {
                    ans.push(eLast);
                    greaterInts.push(eNow);
                    break;
                }
                greaterInts.pop();
            }
            if(greaterInts.empty()) {
                ans.push(-1);
            }
            greaterInts.push(eNow);
        }
        bw.write("" + ans.pop());
        while(!ans.empty()) bw.write(" " + ans.pop());
        bw.flush();
        bw.close();
    }
}