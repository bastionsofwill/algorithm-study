import java.util.LinkedList;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class BOJ10828 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static void println(int v) throws IOException {
        println(v+"");
    }
    static void println(String s) throws IOException {
        bw.write(s+"\n");
    }
    public LinkedList<Integer> s = new LinkedList<>();
    public void push(int e) {
        this.s.add(e);
    }
    public void printPop() throws IOException {
        if(this.s.isEmpty()) {
            println(-1);
            return;
        }
        println(this.s.removeLast());
    }
    public void printSize() throws IOException {
        println(this.s.size());
    }
    public void printIsempty() throws IOException {
        println(this.s.isEmpty() ? 1:0);
    }
    public void printTop() throws IOException {
        if(this.s.isEmpty()) {
            println(-1);
            return;
        }
        println(this.s.getLast());
    }
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        BOJ10828 boj10828 = new BOJ10828();
        for(int i = 0; i < N; i++) {
            String[] input = sc.nextLine().split(" ");
            switch (input[0]) {
                case "push":
                    boj10828.push(Integer.parseInt(input[1]));
                    break;
                case "pop":
                    boj10828.printPop();
                    break;
                case "size":
                    boj10828.printSize();
                    break;
                case "empty":
                    boj10828.printIsempty();
                    break;
                case "top":
                    boj10828.printTop();
                    break;
                default:
                    break;
            }
        }
        sc.close();
        bw.flush();
    }
}
