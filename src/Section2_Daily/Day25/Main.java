package Section2_Daily.Day25;

import java.util.Arrays;

public class Main {


    public static void main(String[] args) {
        int[] output = mergeSort(new int[]{3, 1, 7, 5, 2, 21, 15, 13});
        System.out.println(Arrays.toString(output)); // --> [1, 3, 21]
    }

    static int[] sorted;

    public static int[] mergeSort(int[] arr) {
        sorted = new int[arr.length];
        merge_sort(arr, 0, arr.length-1);

        return sorted;
    }

    // Top-down 방식
    private static void merge_sort(int[] a, int left, int right){
        if(left == right) return; // lf=rt, 부분리스트 크기가 1일 때 더 이상 쪼갤 수 없으므로 리턴

        int mid = (left + right) / 2; // 절반 나누기

        merge_sort(a, left, mid); // 왼쪽 절반
        merge_sort(a, mid + 1, right); // 오른쪽 절밤

        merge(a, left, mid, right); // 병합
    }

    private static void merge(int[] a, int left, int mid, int right){
        int l = left; // 왼쪽 부분리스트 시작점
        int r = mid + 1; // 오른쪽 부분리스트의 시작점
        int idx = left; // 채워넣을 배열의 인덱스

        while(l <= mid && r <= right){
            // 왼쪽 부분리스트 l번째 원소가 오른쪽 부분리스트 r번째 원소보다 작거나 같을 경우
            // 왼쪽의 l번째 원소르 ㄹ새 배열에 넣고 l과 idx를 1 증가시킨다.

            if(a[l] <= a[r]){
                sorted[idx] = a[l];
                idx++;
                l++;
            }
            // 오른쪽 부분리스트 r번째 원소가 왼쪽 부분리스트 l번째 원소보다 작거나 같을 경우
            // 오른쪽의 r번째 원소를 새 배열에 넣고 r과 idx를 1 증가시킨다.
            else {
                sorted[idx] = a[r];
                idx++;
                r++;
            }
        }

        // 왼쪽 부분리스트가 먼저 모두 새 배열에 채워졌을 경우 (l > mid)
        // = 오른쪽 부분리스트 원소가 아직 남아있을 경우
        // 오른쪽 부분리스트의 나머지 원소들을 새 배열에 채워준다.
        if(l > mid){
            while(r <= right){
                sorted[idx] = a[r];
                idx++;
                r++;
            }
        }
        // 오른쪽 부분리스트가 먼저 모두 새 배열에 채워졌을 경우(r > right)
        // = 왼쪽 부분리스트 원소가 아직 남아 있을 경우
        // 왼쪽 부분리스트의 나머지 원소들을 새 배열에 채워준다.
        else{
            while(l <= mid) {
                sorted[idx] = a[l];
                idx++;
                l++;
            }
        }
        // 정렬된 새 배열을 기존의 배열에 복사하여 옮겨줌
        for (int i = left; i <= right; i++) {
            a[i] = sorted[i];
        }
    }
}
