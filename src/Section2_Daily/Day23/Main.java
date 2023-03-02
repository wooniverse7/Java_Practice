package Section2_Daily.Day23;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] output = quickSort(new int[]{3, 1, 21});
        System.out.println(Arrays.toString(output)); // --> [1, 3, 21]
    }

    public static int[] quickSort(int[] arr) {
        // TODO:
        r_pivot_sort(arr, 0, arr.length - 1);

        return arr;
    }

    private static void r_pivot_sort(int[] a, int lo, int hi) {

        if(lo >= hi) {
            return;
        }

        int pivot = partition(a, lo, hi);

        r_pivot_sort(a, lo, pivot - 1);
        r_pivot_sort(a, pivot + 1, hi);
    }


    private static int partition(int[] a, int left, int right) {

        int lo = left;
        int hi = right;
        int pivot = a[right];		// 부분리스트의 오른쪽 요소를 피벗으로 설정

        // lo가 hi보다 작을 때 까지만 반복한다.
        while(lo < hi) {

            while(a[lo] < pivot && lo < hi) {
                lo++;
            }

            while(a[hi] >= pivot && lo < hi) {
                hi--;
            }

            // 교환 될 두 요소를 찾았으면 두 요소를 바꾼다.
            swap(a, lo, hi);
        }

        swap(a, right, hi);

        // 두 요소가 교환되었다면 피벗이었던 요소는 hi에 위치하므로 hi를 반환한다.
        return hi;
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
