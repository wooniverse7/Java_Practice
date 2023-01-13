package Section2.recursion;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        System.out.println(arrSum(arr));
    }

    public static int arrSum(int[] arr){

        if(arr.length == 0) return 0;

        int[] tail = Arrays.copyOfRange(arr, 1, arr.length);
        // arr의 idx 1부터 마지막까지 복사해서 tail에 입력

        return arr[0] + arrSum(tail);
    }
}
