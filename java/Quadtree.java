import java.util.Scanner;

public class Quadtree {
    public static String reverseQuadTree(String input) {
        if(input.length() == 1) return input;
        char firstLetter = input.charAt(0);
        if(firstLetter != 'x') {
            return Character.toString(firstLetter);
        } else {
            String[] output = new String[4];
            for(int outputIndex = 0; outputIndex < 4; outputIndex++) {
                output[outputIndex] = reverseQuadTree(input.substring(1));
                input = input.substring(output[outputIndex].length());
            }
            return 'x' + output[2] + output[3] + output[0] + output[1];
        }
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        scanner.nextLine();
        for(int testcase = 0; testcase < T; testcase++) {
            String input = scanner.nextLine();
            System.out.println(reverseQuadTree(input));
        }
        scanner.close();
    }
}