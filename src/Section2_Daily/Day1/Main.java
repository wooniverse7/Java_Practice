package Section2_Daily.Day1;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        String str = "hello world";

        System.out.println(new Solution().firstCharacter(str));
    }



}

class Solution {
    public String firstCharacter(String str) {
        // TODO:
        if(str.length() == 0) return str;

        String[] arr = str.split(" ");
        char[] ch = new char[arr.length];

        for (int i = 0; i < arr.length; i++) {
            ch[i] = arr[i].charAt(0);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ch.length; i++) {
            sb.append(ch[i]);
        }

        return sb.toString();
    }
}