import java.util.Scanner;

public class Clocksync {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        scanner.nextLine();
        for(int testcase = 0; testcase < T; testcase++) {
            int[] time = new int[16];
            String clocks = scanner.nextLine();
            String[] clockArray = clocks.split(" ");
            int timeIndex = 0;
            for(String el : clockArray) {
                time[timeIndex] = Integer.parseInt(el)%12;
                System.out.print(time[timeIndex]);
                timeIndex++;
            }
            int[][] switchArray = {{0, 1, 2},
                                   {3, 7, 9, 11},
                                   {4, 10, 14, 15},
                                   {0, 4, 5, 6, 7},
                                   {6, 7, 8, 10, 12},
                                   {0, 2, 14, 15},
                                   {3, 14, 15},
                                   {4, 5, 7, 14, 15},
                                   {1, 2, 3, 4, 5},
                                   {3, 4, 5, 9, 13}
                                };
            
        }
        scanner.close();
    }
    
}
