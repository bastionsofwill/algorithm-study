import java.util.Scanner;

public class Picnic {
    public static int findNextSrc(int[] statusArray) {
        int ret = 0;
        for(int el : statusArray) {
            if(el == 0) {
                return ret;
            } else ret++;
        }
        return -1;
    }
    public static int recursiveMatch(int[] statusArray, int src, int[][] friendshipArray) {
        int numMatched = 0;
        for(int el : statusArray) {
            numMatched += el;
        }
        if(numMatched == statusArray.length) {
            return 1;
        }
        int ans = 0;
        int nextSrc;
        int[] updatedStatusArray = statusArray.clone();
        for(int dst = src + 1; dst < statusArray.length; dst++) {
            if(friendshipArray[src][dst] == 1 && statusArray[dst] == 0) {
                updatedStatusArray[src] = 1;
                updatedStatusArray[dst] = 1;
                nextSrc = findNextSrc(updatedStatusArray);
                ans += recursiveMatch(updatedStatusArray, nextSrc, friendshipArray);
                updatedStatusArray[src] = 0;
                updatedStatusArray[dst] = 0;
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