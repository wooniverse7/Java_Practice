package Section2_Daily.OneNote;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Character[][] matrix = new Character[][]{
                {'A', 'B', 'C'},
                {'D', 'E', 'F'},
                {'G', 'H', 'I'},
        };
        String output = spiralTraversal(matrix);
        System.out.println(output); // --> "ABCFIHGDE"

        matrix = new Character[][]{
                {'T', 'y', 'r', 'i'},
                {'i', 's', 't', 'o'},
                {'n', 'r', 'e', 'n'},
                {'n', 'a', 'L', ' '},
        };
        output = spiralTraversal(matrix);
        System.out.println(output); // --> 'Tyrion Lannister'
    }


    public static String spiralTraversal(Character[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        // Defining the boundaries of the matrix.
        int top = 0, bottom = rows - 1, left = 0, right = cols - 1;

        // Defining the direction in which the array is to be traversed.
        int dir = 1;
        StringBuilder sb = new StringBuilder();

        while (top <= bottom && left <= right) {

            if (dir == 1) {    // moving left->right
                for (int i = left; i <= right; ++i) {
                    sb.append(matrix[top][i]);
//                    System.out.print(matrix[top][i] + " ");
                }
                // Since we have traversed the whole first
                // row, move down to the next row.
                ++top;
                dir = 2;
            } else if (dir == 2) {     // moving top->bottom
                for (int i = top; i <= bottom; ++i) {
                    sb.append(matrix[i][right]);
//                    System.out.print(matrix[i][right] + " ");
                }
                // Since we have traversed the whole last
                // column, move left to the previous column.
                --right;
                dir = 3;
            } else if (dir == 3) {     // moving right->left
                for (int i = right; i >= left; --i) {
                    sb.append(matrix[bottom][i]);
//                    System.out.print(matrix[bottom][i] + " ");
                }
                // Since we have traversed the whole last
                // row, move up to the previous row.
                --bottom;
                dir = 4;
            } else if (dir == 4) {     // moving bottom->up
                for (int i = bottom; i >= top; --i) {
                    sb.append(matrix[i][left]);
//                    System.out.print(matrix[i][left] + " ");
                }
                // Since we have traversed the whole first
                // col, move right to the next column.
                ++left;
                dir = 1;
            }
        }

        String rst = sb.toString();
        return rst;
    }


    public static int getItemFromTwoSortedArrays(int[] arr1, int[] arr2, int k) {
        int leftIdx = 0;
        int rightIdx = 0;
        while (k > 0) {
            // 이진 탐색을 위해 각 배열에서 k를 절반으로 쪼개서 카운트 한다.
            int cnt = (int)Math.ceil(((double) k) / 2);
            int leftStep = cnt;
            int rightStep = cnt;

            // 엣지 케이스
            // 카운트가 남았음에도 배열의 끝에 도달하면 k를 나머지 배열쪽으로 넘긴다.
            if (leftIdx == arr1.length) {
                rightIdx = rightIdx + k;
                break;
            }

            if (rightIdx == arr2.length) {
                leftIdx = leftIdx + k;
                break;
            }

            // 엣지 케이스
            // 현재 카운트가 남아있는 후보 요소들보다 많을 경우, leftStep(현재 할당량)을 남아있는 요소들의 개수로 바꾼다.
            if (cnt > arr1.length - leftIdx) leftStep = arr1.length - leftIdx;
            if (cnt > arr2.length - rightIdx) rightStep = arr2.length - rightIdx;

            // 두 배열의 현재 검사 요소 위치를 비교해서, 그 값이 작은 배열은 비교한 위치 앞에 있는 요소들을 모두 후보군에서 제외시킨다.
            if (arr1[leftIdx + leftStep - 1] < arr2[rightIdx + rightStep - 1]) {
                leftIdx = leftIdx + leftStep;
                // 처리가 끝나면 k값을 절반으로 떨어뜨린다.
                k = k - leftStep;
            } else {
                rightIdx = rightIdx + rightStep;
                k = k - rightStep;
            }
        }
        int leftMax = (leftIdx - 1 < arr1.length) ? arr1[leftIdx - 1] : -1;
        int rightMax = (rightIdx - 1 < arr2.length) ? arr2[rightIdx - 1] : -1;

        return Math.max(leftMax, rightMax);
    }

    public static int binarySearch(int[] arr, int target) {
        // TODO:
        int lf = 0;
        int rt = arr.length - 1;

        while(lf <= rt){
            int mid = (lf + rt) / 2;

            if(arr[mid] == target){
                return mid;
            }else if(arr[mid] > target){
                rt = mid - 1;
            }else{
                lf = mid + 1;
            }
        }

        return -1;
    }
}
