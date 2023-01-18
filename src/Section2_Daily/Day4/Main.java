package Section2_Daily.Day4;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String[] arr = {"where", "is", "the", "longest", "word"};
        System.out.println(Arrays.toString(removeExtremes(arr)));
    }

    static public String[] removeExtremes(String[] arr) {

        if(arr.length == 0) return null;

        int shortestLen = 20;
        int longestLen = 0;
        int shortestIdx = 0;
        int longestIdx = 0;

        // 마지막 단어로 갱신됨
        for (int i = 0; i < arr.length; i++) {
            if(arr[i].length() <= shortestLen){
                shortestLen = arr[i].length();
                shortestIdx = i; // 1
            }
            if(arr[i].length() >= longestLen){
                longestLen = arr[i].length();
                longestIdx = i; // 3
            }
        }

        String[] rst = new String[arr.length-2];
        int idx = 0;

        for (int i = 0; i < arr.length; i++) {
            if(i != shortestIdx && i != longestIdx){
                rst[idx++] = arr[i];
            }
        }

        return rst;
    }
}
