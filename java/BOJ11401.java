import java.util.Scanner;

public class BOJ11401 {
    int MOD = 1000000007;
    int[] facMods = new int[4000001];
    public BOJ11401() {
		long res = 1;
        for(int i = 1; i < 4000001; i++) {
			res = (res*i)%MOD;
			facMods[i] = (int)res;
		}
    }
    public long calcPowMod(long N, int p) {
        if(p == 1) return N%MOD;
        long temp = calcPowMod(N, p/2);
        long evenAns = (temp*temp)%MOD;
        if(p%2 == 0) return evenAns;
        return ((N%MOD)*evenAns)%MOD;
    }
    public int calcCombinationMod(int N, int K) {
        if(N == K || K == 0) return 1;
        long nFacMod = this.facMods[N];
        long kFacMod = this.facMods[K];
        long nmkFacMod = this.facMods[N - K];
        long ans = nFacMod*calcPowMod(kFacMod*nmkFacMod, MOD - 2);
        return (int)(ans%MOD);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        sc.close();
        BOJ11401 boj11401 = new BOJ11401();
        System.out.println(boj11401.calcCombinationMod(N, K));
    }
}
