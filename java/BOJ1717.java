import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1717 {
    static int[][] univSet = new int[1000001][2];
    static int find(int e) {
        if(univSet[e][0] == e) return e;
        else return find(univSet[e][0]);
    }
    static void union(int e1, int e2) {
        int e1Root = find(e1);
        int e2Root = find(e2);
        if(e1Root != e2Root) {
            int h1 = univSet[e1Root][1];
            int h2 = univSet[e2Root][1];
            if(h1 < h2) univSet[e1Root][0] = e2Root;
            else if(h1 == h2) {
                univSet[e2Root][0] = e1Root;
                univSet[e1Root][1]++;
            } else univSet[e2Root][0] = e1Root;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        for(int i = 0; i < N + 1; i++) {
            univSet[i][0] = i;
        }
        int M = Integer.parseInt(st.nextToken());
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());
            int e1 = Integer.parseInt(st.nextToken());
            int e2 = Integer.parseInt(st.nextToken());
            if(op == 0) union(e1, e2);
            else {
                if(find(e1) == find(e2)) System.out.println("YES");
                else System.out.println("NO");
            }
        }
        br.close();
    }
}
