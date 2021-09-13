import java.util.*;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        
        while(n != 0) {
            int r = n % k;
            n /= k;
            sb.append(r);
        }
        
        String str = sb.reverse().toString();
        int len = str.length();
        ArrayList <Long> list = new ArrayList<> ();
        long num = 0;
        int max = 0;
        
        for(int i = 0; i < len; i++) {
            if(str.charAt(i) == '0') {
                if(num != (long) 0) {
                    list.add(num);
                    
                    if(max < Math.sqrt(num))
                        max = ((int) Math.sqrt(num)) + 1;
                }
                num = 0;
            } else {
                num *= 10;
                num += (long) (str.charAt(i) - '0');
            }
        }
        
        if(num != (long) 0) {
            list.add(num);
            
            if(max < Math.sqrt(num))
                max = ((int) Math.sqrt(num)) + 1;
        }
        
        boolean isPrime[] = new boolean[max + 1];
        
        for(int i = 2; i <= max; i++)
            isPrime[i] = true;
        
        for(int i = 2; i <= max; i++)
            for(int j = i + i; j <= max; j += i)
                isPrime[j] = false;
        
        ArrayList <Integer> primeList = new ArrayList<>();
        
        for(int i = 2; i <= max; i++)
            if(isPrime[i])
                primeList.add(i);
        
        for(int i = 0; i < list.size(); i++) {
            num = list.get(i);
            int idx = 0;
            boolean flag = true;
            
            if(num == (long) 1)
                flag = false;
            
            while(idx < primeList.size() && primeList.get(idx) < num) {
                if(num % primeList.get(idx) == 0) {
                    flag = false;
                    break;
                }
                idx++;
            }
            
            if(flag)
                answer++;
        }
        
        return answer;
    }
}