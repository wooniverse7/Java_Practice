package Section2_Daily.Day3;

import java.util.HashMap;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        String str = "aaaaaccccbbbbb";
        System.out.println(new Solution().ABCheck(str));
    }
}

class Solution {
    public boolean ABCheck(String str) {
        // TODO:
        str = str.toLowerCase();
        for (int i = 0; i < str.length(); i++) {
            if(i+4 > str.length()-1) break;
            if(str.charAt(i) == 'a'){
                if(str.charAt(i+4) == 'b') return true;
            }
            if(str.charAt(i) == 'b'){
                if(str.charAt(i+4) == 'a') return true;
            }
        }
        return false;
    }
}


