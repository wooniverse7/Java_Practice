package Section2_Daily.Day6;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        String[] str = {"YCDt", "oao", "unI"};

        System.out.println(new Solution().readVertically(str));

    }
}

class Solution {
    public String readVertically(String[] arr) {
        int maxLength = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i].length() > maxLength){
                maxLength = arr[i].length();
            }
        }

        // 새로 만든 배열을 담을 변수
        // 각 인덱스에 arr의 원소중 각 인덱스를 세로로 집어넣음
        String[] tmp = new String[maxLength];

        // arr 원소를 다 돌 때 까지
        for (int i = 0; i < arr.length; i++) {
            String cur = arr[i];
            for (int j = 0; j < cur.length(); j++) {
                // 빈 배열 일 때
                if(tmp[j] == null) {
                    tmp[j] = Character.toString(cur.charAt(j));
                }else{
                    tmp[j] = tmp[j] + cur.charAt(j);
                }

            }
        }
        // arr 각 원소를 하나씩
        String rst = "";
        for (int i = 0; i < tmp.length; i++) {
            rst = rst + tmp[i];
        }

        return rst;
    }
}
