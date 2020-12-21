import java.util.Scanner;
import java.util.ArrayList;

public class Wildcard {
    public static boolean isAsterisk(String s) {
        for(int i = 0; i < s.length(); i++) if(s.charAt(i) != '*') return false;
        return true;
    }
    public static boolean isPattern(String wildcardString, String fileName) {
        int wLen = wildcardString.length();
        int fLen = fileName.length();
        int wIndex = 0;
        int fIndex = 0;
        for(wIndex = 0; wIndex < wLen; wIndex++) {
            if(isAsterisk(wildcardString)) return true;
            if(wildcardString.charAt(wIndex) == '*') {
                for(int subFileIndex = fLen - 1; subFileIndex > fIndex; subFileIndex--) {
                    if(isPattern(wildcardString.substring(wIndex + 1), fileName.substring(subFileIndex))) return true;
                }
                return false;
            }
            if(wildcardString.charAt(wIndex) == fileName.charAt(fIndex) || wildcardString.charAt(wIndex) == '?') {
                fIndex++;
                if(fIndex == fLen) break;
            }
        }
        if(wIndex == wLen - 1 && fIndex == fLen) return true;
        else if(fIndex != fLen) return false;
        else if(isAsterisk(wildcardString.substring(wIndex + 1))) return true;
        return false;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        scanner.nextLine();
        for(int testcase = 0; testcase < T; testcase++) {
            String wildcardString = scanner.nextLine();
            int N = scanner.nextInt();
            scanner.nextLine();
            ArrayList<String> fileList = new ArrayList<String>();
            for(int fileIndex = 0; fileIndex < N; fileIndex++) {
                fileList.add(scanner.nextLine());
            }
            fileList.sort(null);
            for(int i = 0; i < N; i++) {
                isPattern(wildcardString, fileList.get(i));
            }
        }
        scanner.close();
    }
}
