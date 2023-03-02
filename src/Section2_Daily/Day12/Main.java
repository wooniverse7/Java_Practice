package Section2_Daily.Day12;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // 23번
        System.out.println("fibonacci = " + fibonacci(15));
        // 24번
        int[] base = new int[]{10, 99, 123, 7};
        int[] sample = new int[]{7, 99, 123, 10};
        int[] base2 = new int[]{1, 2, 3, 4, 5};
        int[] sample2 = new int[]{1, 3};
        System.out.println(isSubsetOf(base, sample));
        System.out.println(isSubsetOf(base2, sample2));
    }

    static int[] memo = new int[30];
    static public int fibonacci(int num) {
        if(num < 2) return num;
        else if(memo[num] != 0){
            return memo[num];
        }else{
            return memo[num] = fibonacci(num-1) + fibonacci(num-2);
        }
    }

    static public boolean isSubsetOf(int[] base, int[] sample) {
        // 이진 탐색으로 탐색?
        Arrays.sort(base);

        for (int i = 0; i < sample.length; i++) {
            int n = sample[i];
            if(!binarySearch(n, base))
                return false;
        }
        return true;
    }

    static boolean binarySearch(int n, int[] base){

        int lf = 0;
        int rt = base.length - 1;

        while(lf <= rt){
            int mid = (lf + rt) / 2;
            if(n == base[mid]) return true;
            else if(n > base[mid]){
                lf = mid + 1;
            }else{
                rt = mid - 1;
            }
        }

        return false;
    }
}

// n = 100 일 때
// n = 25 일 때
// n = 50 일 때
// base = {10 25 50 75 100 130 160 200}

//        mid = 3; base[3] = 75;
//                rt = mid로 하면
//                lf = 0, rt = 3, mid = 1 = 25;
//                lf = 1, rt = 3 mid = 2;
//
//
//                0 1 2 3 4 5 6 7