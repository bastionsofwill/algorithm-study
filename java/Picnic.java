import java.util.Scanner;

public class Picnic {
    public static int recursiveMatch(int[] statusArray, int src, int[][] friendshipArray) {
        int numMatched = 0;
        for(int el : statusArray) {
            numMatched += el;
        }
        if(numMatched == statusArray.length) {
            return 1;
        }
        int ans = 0;
        int nextSrc = -1;
        int[] updatedStatusArray = statusArray.clone();
        for(int dst = src + 1; dst < statusArray.length; dst++) {
            if(friendshipArray[src][dst] == 1) {
                nextSrc = ((nextSrc == -1) ? dst + 1 : nextSrc);
                updatedStatusArray[src] = 1;
                updatedStatusArray[dst] = 1;
                ans += recursiveMatch(updatedStatusArray, nextSrc, friendshipArray);
            } else {
                nextSrc = ((nextSrc == -1) ? dst : nextSrc);
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for(int testCase = 0; testCase < T; testCase++) {
            int N = scanner.nextInt();
            int M = scanner.nextInt();
            int pair1, pair2;
            int[][] friendshipArray = new int[N][N];
            for(int pairIdx = 0; pairIdx < M; pairIdx++) {
                pair1 = scanner.nextInt();
                pair2 = scanner.nextInt();
                friendshipArray[pair1][pair2] = 1;
                friendshipArray[pair2][pair1] = 1;
            }
            System.out.println(recursiveMatch(new int[N], 0, friendshipArray));
        }  
        scanner.close();
    }
}