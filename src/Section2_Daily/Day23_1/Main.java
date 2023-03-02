package Section2_Daily.Day23_1;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        int[] output = insertionSort(new int[]{3, 1, 21});
        System.out.println(output); // --> [1, 3, 21]

        int[] output2 = radixSort(new int[]{3, 1, 21});
        System.out.println(output2); // --> [1, 3, 21]
    }

    public static int[] insertionSort(int[] arr) {
        // TODO:
        insertion_sort(arr, arr.length);

        return arr;
    }

    private static void insertion_sort(int[] a, int size) {


        for(int i = 1; i < size; i++) {
            // 타겟 넘버
            int target = a[i];

            int j = i - 1;

            // 타겟이 이전 원소보다 크기 전 까지 반복
            while(j >= 0 && target < a[j]) {
                a[j + 1] = a[j];	// 이전 원소를 한 칸씩 뒤로 미룬다.
                j--;
            }

            a[j + 1] = target;
        }

    }

    static final int bucketSize = 10;

    public static int[] radixSort(int[] arr) {
        // TODO:
        radix_Sort(arr.length, arr);

        return arr;
    }

    public static void radix_Sort(int n, int[] arr) {
        //bucket 초기화
        Queue<Integer>[] bucket = new LinkedList[bucketSize];
        for (int i = 0; i < bucketSize; ++i) {
            bucket[i] = new LinkedList<>();
        }

        int factor = 1;

        //정렬할 자릿수의 크기 만큼 반복한다.
        for (int d = 0; d < 2; ++d) {
            for (int i = 0; i < n; ++i) {
                bucket[(arr[i] / factor) % 10].add(arr[i]);
            }

            for (int i = 0, j = 0; i < bucketSize; ++i) {
                while (!bucket[i].isEmpty()) {
                    arr[j++] = bucket[i].poll();
                }
            }

            factor *= 10;
        }
    }
}
