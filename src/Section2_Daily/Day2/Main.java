package Section2_Daily.Day2;

import java.util.Arrays;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        String str = "nEVER  gIVE uP";

        System.out.println(new Solution().letterCapitalize(str));
    }

}

class Solution {
    public String letterCapitalize(String str) {
        // TODO:
        if(str.length() == 0) return str;

        String[] arr = str.split(" ");
        System.out.println(Arrays.toString(arr));
        String rst = "";


        for (int i = 0; i < arr.length; i++) {
            //if(arr[i].isEmpty()) arr[i] = arr[i]; // arr[i]가 공백일 때 공백을 그대로 유지하고 다음으로 넘김
            if(arr[i].isEmpty()) continue; //continue와 같은 기능
            else
            // 각 String의 첫번째 char를 대문자로 변환 후 String으로 변환 + idx 1부터 끝까지를 붙임
            arr[i] = String.valueOf(arr[i].charAt(0)).toUpperCase() + arr[i].substring(1);
        }
        // rst에 arr의 각 String을 공백 하나를 추가해 복사
        rst = String.join(" ", arr);

        return rst;
    }
}
