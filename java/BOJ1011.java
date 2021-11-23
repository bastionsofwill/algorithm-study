import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ1011 {
    public class warpState {
        int pos;
        int lastMoved;
        int depth;
        public warpState(int p, int l, int d) {
            this.pos = p;
            this.lastMoved = l;
            this.depth = d;
        }
    }
    public Queue<warpState> q = new LinkedList<>();
    public int calcNumOfWarp(int src, int dst) {
        q.add(new warpState(dst, 0, 0));
        while(!q.isEmpty()) {
            warpState pWarpState = q.remove();
            int pPos = pWarpState.pos;
            int pLastMoved = pWarpState.lastMoved;
            int pDepth = pWarpState.depth;
            // System.out.println(pPos + " " + pLastMoved + " " + pDepth);
            if(pPos == src - 1 && (pLastMoved == 2 || pLastMoved == 1)) return pDepth;
            if(pPos > src) warp(pPos, pLastMoved, pDepth);
        }
        return -1;
    }
    public void warp(int pos, int lastMoved, int depth) {
        q.add(new warpState(pos - (lastMoved + 1), lastMoved + 1, depth + 1));
        if(lastMoved > 0) q.add(new warpState(pos - lastMoved, lastMoved, depth + 1));
        if(lastMoved > 1) q.add(new warpState(pos - (lastMoved - 1), lastMoved - 1, depth + 1));        
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        BOJ1011 boj1011 = new BOJ1011();
        int x, y;
        for(int tc = 0; tc < T; tc++) {
            x = sc.nextInt();
            y = sc.nextInt();
            sc.nextLine();
            System.out.println(boj1011.calcNumOfWarp(x, y));
        }
        sc.close();
    }
}
