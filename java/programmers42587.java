import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class programmers42587 {
    public static void main(String[] args) {
        int[] priorities = {1, 1, 9, 1, 1, 1};
        int location = 0;
        System.out.println(solution(priorities, location));
    }
    public static int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<int[]> q = new LinkedList<int[]>();
        for(int i = 0; i < priorities.length; i++) {
            int isTarget = (i == location) ? 1 : 0;
            int[] doc = {priorities[i], isTarget};
            q.add(doc);
        }
        Arrays.sort(priorities);
        int[] docNow;
        int printedIdx = priorities.length - 1;
        while(!q.isEmpty()) {
            docNow = q.poll();
            if(docNow[0] == priorities[printedIdx]) {
                printedIdx--;
                answer++;
                if(docNow[1] == 1) return answer;
            } else q.add(docNow);
        }
        return -1;
    }
}