import java.util.Scanner;
import java.util.Arrays;

public class Fence {
    public static int findMidMaxArea(int midAreaHeight, int i, int j, int prev) {
        return Math.max(midAreaHeight*(j - i - 1), prev);
    }
    public static int findMaxArea(int[] input) {
        int fenceLength = input.length;
        if(input.length == 1) return input[0];
        int pivot = fenceLength/2;
        int leftMaxArea = findMaxArea(Arrays.copyOfRange(input, 0, pivot));
        int rightMaxArea = findMaxArea(Arrays.copyOfRange(input, pivot, fenceLength));
        int midAreaHeight = Math.min(input[pivot - 1], input[pivot]);
        int midMaxArea = midAreaHeight*2;
        int i, j;
        if(fenceLength >= 3) {
            i = pivot - 2;
            j = pivot + 1;
            while(true) {
                if(i >= 0 && j < fenceLength) {
                    if(input[i] > input[j]) midAreaHeight = Math.min(input[i--], midAreaHeight);
                    else midAreaHeight = Math.min(input[j++], midAreaHeight);
                    midMaxArea = findMidMaxArea(midAreaHeight, i, j, midMaxArea);
                }
                else if(j < fenceLength) {
                    midAreaHeight = Math.min(input[j++], midAreaHeight);
                    midMaxArea = findMidMaxArea(midAreaHeight, i, j, midMaxArea);
                }
                else if(i >= 0) {
                    midAreaHeight = Math.min(input[i--], midAreaHeight);
                    midMaxArea = findMidMaxArea(midAreaHeight, i, j, midMaxArea);
                }
                else break;
            }
        }
        return Math.max(Math.max(leftMaxArea, rightMaxArea), midMaxArea);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for(int testcase = 0; testcase < T; testcase++) {
            int N = scanner.nextInt();
            int[] input = new int[N];
            for(int num = 0; num < N; num++) {
                input[num] = scanner.nextInt();
            } 
            System.out.println(findMaxArea(input));
        }
        scanner.close();
    }
}
