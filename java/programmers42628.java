import java.util.PriorityQueue;
import java.util.Collections;

public class programmers42628 {
    public static void main(String[] args) {
        String[] input = {"I 1", "I 2", "I 3", "I 4", "I 5", "D -1", "D -1","D -1", "D -1"};
        int[] ans = solution(input);
        System.out.println(ans[0] + " " + ans[1]);
    }
    public static int[] solution(String[] operations) {
        PriorityQueue<Integer> pqMin = new PriorityQueue<Integer>();
        PriorityQueue<Integer> pqMax = new PriorityQueue<Integer>(Collections.reverseOrder());
        int[] answer = {0, 0};
        int pqlen = 0;
        String[] op;
        for(String operation : operations) {
            op = operation.split(" ");
            if(op[0].equals("I")) {
                pqMin.add(Integer.parseInt(op[1]));
                pqMax.add(Integer.parseInt(op[1]));
                pqlen++;
            } else {
                if(pqlen == 0) continue;
                if(op[1].equals("1")) {
                    pqMax.remove();
                    pqlen--;
                    if(pqlen == 0) {
                        pqMin.clear();
                        pqMax.clear();
                    }
                } else {
                    pqMin.remove();
                    pqlen--;
                    if(pqlen == 0) {
                        pqMin.clear();
                        pqMax.clear();
                    }
                }
            }
        }
        if(pqlen > 0) {
            answer[0] = pqMax.poll();
            answer[1] = pqMin.poll();
        }
        return answer;
    }
}
