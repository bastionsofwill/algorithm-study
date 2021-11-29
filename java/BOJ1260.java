import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ1260 {
    public int N;
    public boolean edges[][];
    boolean[] visited;
    public BOJ1260(int N) {
        this.N = N;
        this.edges = new boolean[N][N];
        this.visited = new boolean[N];
    }
    public void addEdges(int n1, int n2) {
        this.edges[n1][n2] = true;
        this.edges[n2][n1] = true;
    }
    public void dfs(int src) {
        this.visited[src] = true;
        System.out.print(src + 1);
        for(int i = 0; i < this.N; i++) {
            if(!this.visited[i] && edges[src][i]) {
                System.out.print(" ");
                dfs(i);
            }
        }
    }
    public void bfs(int src) {
        this.visited = new boolean[this.N];
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        this.visited[src] = true;
        while(!q.isEmpty()) {
            int popped = q.poll();
            if(popped != src) System.out.print(" ");
            System.out.print(popped + 1);
            for(int i = 0; i < this.N; i++) {
                if(!this.visited[i] && edges[popped][i]) {
                    q.add(i);
                    this.visited[i] = true;
                }
            }
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int V = sc.nextInt();
        BOJ1260 boj1260 = new BOJ1260(N);
        for(int i = 0; i < M; i++) {
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            boj1260.addEdges(n1 - 1, n2 - 1);
        }
        boj1260.dfs(V - 1);
        System.out.println();
        boj1260.bfs(V - 1);
        sc.close();
    }
}