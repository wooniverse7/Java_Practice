package Section2_Daily.Day7;

import java.util.Arrays;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        //14번 문제
//        int[] arr = new int[]{1, 3, 6, 13, 54};
//        int[] arr2 = new int[]{1, 3, 5, 9};
//        System.out.println(new Solution().superIncreasing(arr));

        // 15번 문제
//        int a = 25;
//        int b = 4;
//        System.out.println(new Solution().modulo(a, b));

        // 16번 문제
        String str = "abcdgz";
        System.out.println(new Solution().isIsogram(str));
    }
}

class Solution {
    // 14. superIncreasing
    public boolean superIncreasing(int[] arr) {
        // TODO:
        boolean flag = true;

        // arr의 각 원소를 대입할 때 마다 그 전 까지의 배열을 복사해 for문이나 함수로 돌림
        // 끝까지 진행
        for (int i = 1; i < arr.length; i++) {
            int[] tmp = Arrays.copyOfRange(arr, 0, i);
            int sum = 0;
            for (int j = 0; j < tmp.length; j++) {
                sum += tmp[j];
            }
//            System.out.printf("arr[%d] : %d, sum : %d'\n'", i, arr[i], sum);
            if(arr[i] <= sum) {
                flag = false;
                break;
            }
        }

        return flag;
    }

    // 15. modulo
    public Integer modulo(int num1, int num2) {
        if(num2 == 0) return null;
        if(num1 == num2) return 0;

        while(num1 > num2){
            num1 -= num2;
        }

        return num1;
    }

    // 16. isogram
    boolean[] visited = new boolean[26];
    public boolean isIsogram(String str) {
        // TODO:
        // String을 소문자로 변환하기
        str = str.toLowerCase();
        // visited 배열을 만들어서 이미 사용했는 것을 쓰면 바로 false처리
        for (int i = 0; i < str.length(); i++) {
            if(visited[str.charAt(i) - 'a']) return false; // 중복
            System.out.println(str.charAt(i) - 'a');
            visited[str.charAt(i) - 'a'] = true;
        }

        // 중복 X
        return true;
    }
}
