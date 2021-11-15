import java.util.Scanner;
import java.io.IOException;

public class BOJ1004 {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        int ans;
        for(int i = 0; i < T; i++) {
            ans = 0;
            String[] coo = sc.nextLine().split(" ");
            int x1 = Integer.parseInt(coo[0]);
            int y1 = Integer.parseInt(coo[1]);
            int x2 = Integer.parseInt(coo[2]);
            int y2 = Integer.parseInt(coo[3]);
            int N = sc.nextInt();
            sc.nextLine();
            int[][] planetSys = new int[N][3];
            for(int j = 0; j < N; j++) {
                String[] planet = sc.nextLine().split(" ");
                planetSys[j][0] = Integer.parseInt(planet[0]);
                planetSys[j][1] = Integer.parseInt(planet[1]);
                planetSys[j][2] = Integer.parseInt(planet[2]);
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