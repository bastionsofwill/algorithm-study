import java.util.Scanner;
import java.io.IOException;
import java.util.StringTokenizer;

public class BOJ1004 {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        StringTokenizer st;
        int T = Integer.parseInt(sc.nextLine());
        int ans;
        for(int i = 0; i < T; i++) {
            ans = 0;
            st = new StringTokenizer(sc.nextLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(sc.nextLine());
            int[][] planetSys = new int[N][3];
            for(int j = 0; j < N; j++) {
                st = new StringTokenizer(sc.nextLine());
                planetSys[j][0] = Integer.parseInt(st.nextToken());
                planetSys[j][1] = Integer.parseInt(st.nextToken());
                planetSys[j][2] = Integer.parseInt(st.nextToken());
            }
            for(int[] ps: planetSys) {
                double d1Sq = Math.pow(x1 - ps[0], 2) + Math.pow(y1 - ps[1], 2);
                double d2Sq = Math.pow(x2 - ps[0], 2) + Math.pow(y2 - ps[1], 2);
                double rSq = Math.pow(ps[2], 2);
                if((d1Sq < rSq)^(d2Sq < rSq)) ans++;
            }
            System.out.println(ans);
        }
        sc.close();
    }
}