package Section2_Daily.Day5;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};

        System.out.println(Arrays.toString(new Solution().reverseArr(arr)));
    }
}

class Solution {
    public int[] reverseArr(int[] arr){
        if(arr.length == 0) return new int[]{};

        int[] head = Arrays.copyOfRange(arr, arr.length-1, arr.length); // 시작점 - 끝나는 지점 앞
        int[] body = reverseArr(Arrays.copyOfRange(arr, 0, arr.length-1));

        int[] rst = new int[head.length + body.length];
        System.arraycopy(head, 0, rst, 0, head.length);
        System.arraycopy(body, 0, rst, head.length, body.length);
        // 복사 배열, 시작점, 받는 배열, 시작위치, 복사할 길이

        return rst;
    }

}
