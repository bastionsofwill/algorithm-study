import java.util.Scanner;
import java.io.IOException;
import java.util.StringTokenizer;

public class BOJ2606 {
    static int[] computerSet = new int[101];
    static void union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
        if(aRoot < bRoot) computerSet[bRoot] = aRoot;
        else if(aRoot == bRoot) return;
        else computerSet[aRoot] = bRoot;
    }
    static int find(int c) {
        int parent = computerSet[c];
        if(parent == c) return c;
        else return find(parent);
    }
    public static void main(String[] args) throws IOException {
        for(int i = 0; i < 101; i++) {
            computerSet[i] = i;
        }
        Scanner sc = new Scanner(System.in);
        StringTokenizer st;
        int ans = 0;
        int src, dst;
        int N = Integer.parseInt(sc.nextLine());
        int P = Integer.parseInt(sc.nextLine());
        for(int i = 0; i < P; i++) {
            st = new StringTokenizer(sc.nextLine());
            src = Integer.parseInt(st.nextToken());
            dst = Integer.parseInt(st.nextToken());
            union(src, dst);
        }
        sc.close();
        for(int i = 2; i < N + 1; i++) {
            if(find(i) == 1) ans++;
        }
        System.out.println(ans);
    }
}
