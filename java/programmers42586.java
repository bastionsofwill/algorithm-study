import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class programmers42586 {
    public static void main(String[] args) {
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};
        int[] ans = solution(progresses, speeds);
        System.out.println(ans[0]);
        System.out.println(ans[1]);
    }
    public static int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        ArrayList<Integer> ansArr = new ArrayList<Integer>();
        int numFeatures = progresses.length;
        Queue<Integer> q = new LinkedList<Integer>();
        for(int i = 0; i < numFeatures; i++) {
            int pLeft = (100 - progresses[i]);
            int remainder = pLeft%speeds[i] == 0 ? 0 : 1;
            int dLeft = pLeft/speeds[i] + remainder;
            q.add(dLeft);
        }
        int dNow, numDeployedFeature;
        while(!q.isEmpty()) {
            dNow = q.poll();
            numDeployedFeature = 1;
            while(!q.isEmpty() && dNow >= q.peek()) {
                q.poll();
                numDeployedFeature++;
            }
            ansArr.add(numDeployedFeature);
        }
        answer = ansArr.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}