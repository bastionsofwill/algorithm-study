import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class BOJ2667 {
    public ArrayList<Integer> ans = new ArrayList<Integer>();
    int N;
    int[][] townMap;
    public BOJ2667(int N) {
        this.N = N;
        this.townMap = new int[N][N];
    }
    public int dfs(int i, int j) {
        if(i < 0 || i > N -1 || j < 0 || j > N - 1 || townMap[i][j] == 0) return 0;
        townMap[i][j] = 0;
        return 1 + dfs(i - 1, j) + dfs(i + 1, j) + dfs(i, j + 1) + dfs(i, j - 1);
    }
    public void countHouse() {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                // System.out.println(townMap[i][j]);
                if(townMap[i][j] == 1) {
                    ans.add(dfs(i, j));
                }
            }
        }
        System.out.println(ans.size());
        ans.sort(Comparator.naturalOrder());
        for(int e: ans) System.out.println(e);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        BOJ2667 boj2667 = new BOJ2667(N);
        char[] inputRow;
        for(int i = 0; i < N; i++) {
            inputRow = sc.nextLine().toCharArray();
            for(int j = 0; j < N; j++) {
                boj2667.townMap[i][j] = (int)inputRow[j] - 48;
            }
        }
        sc.close();
        boj2667.countHouse();
    }
}
