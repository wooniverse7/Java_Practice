package Section2_Daily.Day17;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int output = rotatedArraySearch(new int[]{4, 5, 6, 0, 1, 2, 3}, 2);
        System.out.println(output);
    }

    public static int rotatedArraySearch(int[] rotated, int target) {
        // 첫 번째 원소를 입력받아서 얼만큼 회전했는지 파악
        // 이진탐색에 회전한 만큼 숫자를 더하거나 빼서 구하기. 나머지 연산 필요

        int lf = 0;
        int rt = rotated.length - 1; // 6

        while(lf <= rt){
            int mid = (lf + rt) / 2;

            if(rotated[mid] == target) {
                return mid;
            }
            // 먼저 정렬 상태부터 구분
            // 왼쪽 검사
            if(rotated[mid] > rotated[lf]){
                // 타겟 검사
                // 배열의 가운데보다 작고 배열의 시작보다 클 때는 upper bound를 반으로 줄인다
                if(target < rotated[mid] && rotated[lf] <= target){
                    rt = mid - 1;
                }else { // target > rotated[mid] 이거나 rotated[left] > target이면
                    lf = mid + 1;
                }
            }else{
                // 오른쪽 절반이 정렬되어 있는 상태
                if (target <= rotated[rt] && rotated[mid] < target) {
                    lf = mid + 1;
                } else {
                    rt = mid - 1;
                }
            }
        }

        return -1;
    }

    public static int rotatedArraySearch2(int[] rotated, int target) {
        int left = 0;
        int right = rotated.length - 1;

        while(left <= right) {
            int middle = (right + left) / 2;

            if(rotated[middle] == target) {
                return middle;
            }

            // {4, 5, 6, 0, 1, 2, 3}, 2
            if (rotated[left] < rotated[middle]) {
                // 왼쪽 절반이 정렬되어 있는 상태
                if (target < rotated[middle] && rotated[left] <= target) {
                    right = middle - 1;
                } else {
                    left = middle + 1;
                }
            } else {
                // 오른쪽 절반이 정렬되어 있는 상태
                if (target <= rotated[right] && rotated[middle] < target) {
                    left = middle + 1;
                } else {
                    right = middle - 1;
                }
            }
        }

        return -1;
    }
}
