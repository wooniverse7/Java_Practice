package Section2_Daily.Day10;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {

        int[] arr1 = {2, 1, 3, 7};
        int[] arr2 = {-5, -4, -3, -1, 999, 10000};

        System.out.println(largestProductOfThree(arr1));
        System.out.println(largestProductOfThree(arr2));

    }

    static public int largestProductOfThree(int[] arr) {
        // TODO:
        ArrayList<Integer> al = new ArrayList<>();

        for (int i = 0; i < arr.length-2; i++) {
            for (int j = i+1; j < arr.length-1; j++) {
                for (int k = j+1; k < arr.length; k++) {
                    al.add(arr[i]*arr[j]*arr[k]);
                }
            }
        }

        Collections.sort(al, Collections.reverseOrder());

        return al.get(0);
    }
}
