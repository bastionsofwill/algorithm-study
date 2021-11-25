import java.util.Arrays;
import java.util.Scanner;

public class BOJ1015 {
    public int[] A, B;
    public void setB() {
        this.B = this.A.clone();
        Arrays.sort(this.B);
    }
    public int getSmallestIdx(int e){
        for(int i = 0; i < this.B.length; i++) {
            if(this.B[i] == e) return i;
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        BOJ1015 boj1015 = new BOJ1015();
        boj1015.A = new int[N];
        for(int i = 0; i < N; i++) boj1015.A[i] = sc.nextInt();
        boj1015.setB();
        for(int aIdx = 0; aIdx < N; aIdx++) {
            int tempIdx = boj1015.getSmallestIdx(boj1015.A[aIdx]);
            boj1015.B[tempIdx] = -1;
            System.out.print(tempIdx);
            if(aIdx != N - 1) System.out.print(" ");
        }
        sc.close();
    }
}