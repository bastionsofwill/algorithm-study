import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class programmers42627 {
    public static int[][] input = {
        {0, 3},
        {2, 6},
        {1, 9}
        
    };
    public static void main(String[] args) {
        System.out.println(solution(input));
    }
    public static int solution(int[][] jobs) {
        int answer = 0;
        int time = 0;
        int numJobs = jobs.length;
        int numJobsAdded = 0;
        Arrays.sort(jobs, new Comparator<int[]>() { 
            @Override public int compare(int[] o1, int[] o2) {
                 if(o1[0] == o2[0]) return o1[1] - o2[1];
                    else return o1[0] - o2[0];
                }
            });
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(500, (int[] job1, int[] job2) -> job1[1] > job2[1] ? 1 : -1);
        while(!pq.isEmpty() || numJobsAdded < numJobs) {
            if(pq.isEmpty()) {
                int [] newJob = jobs[numJobsAdded];
                time = newJob[0];
                pq.add(newJob);
                numJobsAdded++;
            }
            int[] jobNow = pq.poll();
            answer += (time + jobNow[1] - jobNow[0]);
            time += jobNow[1];
            for(int i = numJobsAdded; i < jobs.length; i++) {
                if(jobs[i][0] <= time) {
                    pq.add(jobs[i]);
                    numJobsAdded++;
                } else break;
            }
        }
        return answer/jobs.length;
    }
}
